package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.GestionLibroDigitalController;
import co.edu.uniquindio.poo.bibliotecajfx.model.EstadoLibro;
import co.edu.uniquindio.poo.bibliotecajfx.model.FormatoLibro;
import co.edu.uniquindio.poo.bibliotecajfx.model.LibroDigital;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionLibroDigitalViewController {
    GestionLibroDigitalController gestionLibroDigitalController;
    ObservableList<LibroDigital> listLibrosDigitales = FXCollections.observableArrayList();
    LibroDigital selectedLibroDigital;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableView<LibroDigital> tablaLibrosDigitales;

    @FXML
    private TableColumn<LibroDigital, String> columnaTitulo;

    @FXML
    private TableColumn<LibroDigital, String> columnaAutor;

    @FXML
    private TableColumn<LibroDigital, String> columnaGenero;

    @FXML
    private TableColumn<LibroDigital, String> columnaEstado;

    @FXML
    private TableColumn<LibroDigital, String> columnaFormatoLibro;

    @FXML
    private TableColumn<LibroDigital, String> columnaLinkDescarga;

    @FXML
    private TableColumn<LibroDigital, Integer> columnaAnioPublicacion;

    @FXML
    private TextField textFieldTituloLibroDigital;

    @FXML
    private TextField textFieldAutorLibroDigital;

    @FXML
    private TextField textFieldGeneroLibroDigital;

    @FXML
    private TextField textFieldAnioPublicacionLibroDigital;

    @FXML
    private TextField textFieldLinkDescargaLibroDigital;

    @FXML
    private CheckBox CheckBoxPDF;

    @FXML
    private CheckBox CheckBoxEPUB;

    @FXML
    private CheckBox CheckBoxMOBI;

    @FXML
    private Button btnActualizarLibro;

    @FXML
    private Button btnAnadirLibroDigital;

    @FXML
    private Button btnEliminarLibro;

    @FXML
    private Button btnLimpiarCeldas;

    @FXML
    private Button btnRegresar;
    @FXML
    private App app;

    @FXML
    void onAnadirLibroDigital() {
        agregarLibro();
    }

    @FXML
    void onActualizarLibro() {
        actualizarLibro();
    }

    @FXML
    void onEliminarLibro() {
        eliminarLibro();
    }

    @FXML
    void onRegresar() {
        app.openCrudBibliotecario();
    }

    @FXML
    void onLimpiarCampos() {
        limpiarCampos();
    }

    @FXML
    void initView() {
        CheckBoxPDF.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                CheckBoxEPUB.setSelected(false);
                CheckBoxMOBI.setSelected(false);
            }
        });

        CheckBoxEPUB.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                CheckBoxPDF.setSelected(false);
                CheckBoxMOBI.setSelected(false);
            }
        });

        CheckBoxMOBI.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                CheckBoxPDF.setSelected(false);
                CheckBoxEPUB.setSelected(false);
            }
        });

        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerLibrosDigitales();

        // Limpiar la tabla
        tablaLibrosDigitales.getItems().clear();

        // Agregar los elementos a la tabla
        tablaLibrosDigitales.setItems(listLibrosDigitales);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }
    @FXML
    public void setApp(App app) {
        this.app= app;
        gestionLibroDigitalController = new GestionLibroDigitalController(App.bibliotecario);
        initView();
    }

    @FXML
    public void initDataBinding() {
        columnaTitulo.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getTitulo()));
        columnaAutor.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getAutor()));
        columnaGenero.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getGenero()));
        columnaEstado.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getEstado().toString()));
        columnaAnioPublicacion.setCellValueFactory(celda -> new javafx.beans.property.SimpleIntegerProperty(celda.getValue().getAnioPublicacion()).asObject());
        columnaLinkDescarga.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getLinkDescarga()));
        columnaFormatoLibro.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getFormato().toString()));
    }

    private void mostrarDetalleLibro(LibroDigital libro) {
        if (libro != null) {
            textFieldTituloLibroDigital.setText(libro.getTitulo());
            textFieldAutorLibroDigital.setText(libro.getAutor());
            textFieldGeneroLibroDigital.setText(libro.getGenero());
            textFieldAnioPublicacionLibroDigital.setText(String.valueOf(libro.getAnioPublicacion()));
            textFieldLinkDescargaLibroDigital.setText(libro.getLinkDescarga());
            CheckBoxPDF.setSelected(libro.getFormato() == FormatoLibro.PDF);
            CheckBoxEPUB.setSelected(libro.getFormato() == FormatoLibro.EPUB);
            CheckBoxMOBI.setSelected(libro.getFormato() == FormatoLibro.MOBI);
        }
    }

    @FXML
    private void agregarLibro() {
        if (textFieldTituloLibroDigital.getText().isEmpty() ||
                textFieldAutorLibroDigital.getText().isEmpty() ||
                textFieldGeneroLibroDigital.getText().isEmpty() ||
                textFieldAnioPublicacionLibroDigital.getText().isEmpty() ||
                textFieldLinkDescargaLibroDigital.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos deben estar llenos.");
            return;
        }

        FormatoLibro formato = obtenerFormatoSeleccionado();
        if (formato == null) {
            mostrarAlerta("Error", "Debe seleccionar un formato de libro.");
            return;
        }

        LibroDigital nuevoLibro = new LibroDigital(
                textFieldTituloLibroDigital.getText(),
                textFieldAutorLibroDigital.getText(),
                textFieldGeneroLibroDigital.getText(),
                Integer.parseInt(textFieldAnioPublicacionLibroDigital.getText()) ,
                EstadoLibro.DISPONIBLE,
                textFieldLinkDescargaLibroDigital.getText(),
                formato
        );

        listLibrosDigitales.add(nuevoLibro);
        tablaLibrosDigitales.setItems(listLibrosDigitales);
        gestionLibroDigitalController.crearLibroDigital(nuevoLibro);
        limpiarCampos();
    }

    @FXML
    private void actualizarLibro() {
        LibroDigital libroSeleccionado = tablaLibrosDigitales.getSelectionModel().getSelectedItem();
        if (libroSeleccionado == null) {
            mostrarAlerta("Advertencia", "Debe seleccionar un libro para actualizar.");
            return;
        }

        String tituloAnterior = libroSeleccionado.getTitulo();
        libroSeleccionado.setTitulo(textFieldTituloLibroDigital.getText());
        libroSeleccionado.setAutor(textFieldAutorLibroDigital.getText());
        libroSeleccionado.setGenero(textFieldGeneroLibroDigital.getText());
        libroSeleccionado.setAnioPublicacion(Integer.parseInt(textFieldAnioPublicacionLibroDigital.getText()));
        libroSeleccionado.setLinkDescarga(textFieldLinkDescargaLibroDigital.getText());
        libroSeleccionado.setFormato(obtenerFormatoSeleccionado());
        gestionLibroDigitalController.actualizarLibroDigital(libroSeleccionado.getTitulo(), libroSeleccionado);

        tablaLibrosDigitales.refresh();
        limpiarCampos();
    }

    @FXML
    private void eliminarLibro() {
        LibroDigital libroSeleccionado = tablaLibrosDigitales.getSelectionModel().getSelectedItem();
        if (libroSeleccionado != null) {
            listLibrosDigitales.remove(libroSeleccionado);
            gestionLibroDigitalController.eliminarLibroDigital(libroSeleccionado.getTitulo());
        } else {
            mostrarAlerta("Advertencia", "Debe seleccionar un libro para eliminar.");
        }
    }

    private FormatoLibro obtenerFormatoSeleccionado() {

        if (CheckBoxPDF.isSelected()) {
            return FormatoLibro.PDF;
        }
        if (CheckBoxEPUB.isSelected()) {
            return FormatoLibro.EPUB;
        }
        if (CheckBoxMOBI.isSelected()) {
            return FormatoLibro.MOBI;
        }
        return null;
    }

    private void limpiarCampos() {
        textFieldTituloLibroDigital.clear();
        textFieldAutorLibroDigital.clear();
        textFieldGeneroLibroDigital.clear();
        textFieldAnioPublicacionLibroDigital.clear();
        textFieldLinkDescargaLibroDigital.clear();
        CheckBoxPDF.setSelected(false);
        CheckBoxEPUB.setSelected(false);
        CheckBoxMOBI.setSelected(false);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void obtenerLibrosDigitales() {
        listLibrosDigitales.addAll(gestionLibroDigitalController.obtenerListaLibrosDigitales());
    }

    @FXML
    private void listenerSelection() {
        tablaLibrosDigitales.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedLibroDigital = newSelection;
            mostrarDetalleLibro(selectedLibroDigital);
        });
    }

}