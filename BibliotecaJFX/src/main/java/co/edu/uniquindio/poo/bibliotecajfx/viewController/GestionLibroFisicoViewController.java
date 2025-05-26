package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.GestionLibroFisicoController;
import co.edu.uniquindio.poo.bibliotecajfx.model.EstadoLibro;
import co.edu.uniquindio.poo.bibliotecajfx.model.LibroFisico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionLibroFisicoViewController {
GestionLibroFisicoController gestionLibroFisicoController;
ObservableList<LibroFisico> listLibrosFisicos = FXCollections.observableArrayList();
LibroFisico selectedLibroFisico;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<LibroFisico> tablaLibrosFisicos;

    @FXML
    private TableColumn<LibroFisico, String> columnaTitulo;

    @FXML
    private TableColumn<LibroFisico, String> columnaAutor;

    @FXML
    private TableColumn<LibroFisico, String> columnaGenero;

    @FXML
    private TableColumn<LibroFisico, String> columnaEstado;

    @FXML
    private TableColumn<LibroFisico, String> columnaEditorial;

    @FXML
    private TableColumn<LibroFisico, Integer> columnaNumeroPaginas;

    @FXML
    private TableColumn<LibroFisico, String> columnaUbicacionBiblioteca;

    @FXML
    private TableColumn<LibroFisico, Integer> columnaAnioPublicacion;

    @FXML
    private TextField textFieldTituloLibroFisico;

    @FXML
    private TextField textFieldAutorLibroFisico;

    @FXML
    private TextField textFieldGeneroLibroFisico;

    @FXML
    private TextField textFieldAnioPublicacionLibroFisico;

    @FXML
    private TextField textFieldEditorialLibroFisico;

    @FXML
    private TextField textFieldNumeroPaginasLibroFisico;
    @FXML
    private TextField textFieldUbicacionLibroFisico;


    @FXML
    private Button btnActualizarLibro;

    @FXML
    private Button btnAnadirLibroFisico;
    @FXML
    private Button btnLimpiarCeldas;

    @FXML
    private Button btnEliminarLibro;

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


        initDataBinding();


        obtenerLibrosDigitales();


        tablaLibrosFisicos.getItems().clear();


        tablaLibrosFisicos.setItems(listLibrosFisicos);


        listenerSelection();
    }
    @FXML
    public void setApp(App app) {
        this.app= app;
        gestionLibroFisicoController = new GestionLibroFisicoController(App.bibliotecario);
        initView();
    }

    @FXML
    public void initDataBinding() {
        columnaTitulo.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getTitulo()));
        columnaAutor.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getAutor()));
        columnaGenero.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getGenero()));
        columnaEstado.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getEstado().toString()));
        columnaAnioPublicacion.setCellValueFactory(celda -> new javafx.beans.property.SimpleIntegerProperty(celda.getValue().getAnioPublicacion()).asObject());
        columnaNumeroPaginas.setCellValueFactory(celda -> new javafx.beans.property.SimpleIntegerProperty((celda.getValue().getNumeroPaginas())).asObject());
        columnaEditorial.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getEditorial()));
        columnaUbicacionBiblioteca.setCellValueFactory(celda->new javafx.beans.property.SimpleStringProperty(celda.getValue().getUbicacionBiblioteca()));
    }

    private void mostrarDetalleLibro(LibroFisico libro) {
        if (libro != null) {
            textFieldTituloLibroFisico.setText(libro.getTitulo());
            textFieldAutorLibroFisico.setText(libro.getAutor());
            textFieldGeneroLibroFisico.setText(libro.getGenero());
            textFieldAnioPublicacionLibroFisico.setText(String.valueOf(libro.getAnioPublicacion()));
            textFieldEditorialLibroFisico.setText(libro.getEditorial());
            textFieldNumeroPaginasLibroFisico.setText(String.valueOf(libro.getNumeroPaginas()));
            textFieldUbicacionLibroFisico.setText(libro.getUbicacionBiblioteca());
        }
    }

    @FXML
    private void agregarLibro() {
        if (textFieldTituloLibroFisico.getText().isEmpty() ||
                textFieldAutorLibroFisico.getText().isEmpty() ||
                textFieldGeneroLibroFisico.getText().isEmpty() ||
                textFieldAnioPublicacionLibroFisico.getText().isEmpty() ||
                textFieldEditorialLibroFisico.getText().isEmpty() || textFieldUbicacionLibroFisico.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos deben estar llenos.");
            return;
        }


        LibroFisico nuevoLibro = new LibroFisico(
                textFieldTituloLibroFisico.getText(),
                textFieldAutorLibroFisico.getText(),
                textFieldGeneroLibroFisico.getText(),
                EstadoLibro.DISPONIBLE,
                Integer.parseInt(textFieldAnioPublicacionLibroFisico.getText()),
                Integer.parseInt(textFieldNumeroPaginasLibroFisico.getText()),
                textFieldEditorialLibroFisico.getText(),
                textFieldUbicacionLibroFisico.getText()
        );

        listLibrosFisicos.add(nuevoLibro);
        tablaLibrosFisicos.setItems(listLibrosFisicos);
        gestionLibroFisicoController.crearLibroFisico(nuevoLibro);
        limpiarCampos();
    }

    @FXML
    private void actualizarLibro() {
        LibroFisico libroSeleccionado = tablaLibrosFisicos.getSelectionModel().getSelectedItem();
        if (libroSeleccionado == null) {
            mostrarAlerta("Advertencia", "Debe seleccionar un libro para actualizar.");
            return;
        }

        String tituloAnterior = libroSeleccionado.getTitulo();
        libroSeleccionado.setTitulo(textFieldTituloLibroFisico.getText());
        libroSeleccionado.setAutor(textFieldAutorLibroFisico.getText());
        libroSeleccionado.setGenero(textFieldGeneroLibroFisico.getText());
        libroSeleccionado.setAnioPublicacion(Integer.parseInt(textFieldAnioPublicacionLibroFisico.getText()));
        libroSeleccionado.setEditorial(textFieldEditorialLibroFisico.getText());
        libroSeleccionado.setNumeroPaginas(Integer.parseInt(textFieldNumeroPaginasLibroFisico.getText()));
        gestionLibroFisicoController.actualizarLibroFisico(libroSeleccionado.getTitulo(), libroSeleccionado);

        tablaLibrosFisicos.refresh();
        limpiarCampos();
    }

    @FXML
    private void eliminarLibro() {
        LibroFisico libroSeleccionado = tablaLibrosFisicos.getSelectionModel().getSelectedItem();
        if (libroSeleccionado != null) {
            listLibrosFisicos.remove(libroSeleccionado);
            gestionLibroFisicoController.eliminarLibroFisico(libroSeleccionado.getTitulo());
        } else {
            mostrarAlerta("Advertencia", "Debe seleccionar un libro para eliminar.");
        }
    }


    private void limpiarCampos() {
        textFieldTituloLibroFisico.clear();
        textFieldAutorLibroFisico.clear();
        textFieldGeneroLibroFisico.clear();
        textFieldAnioPublicacionLibroFisico.clear();
        textFieldEditorialLibroFisico.clear();
        textFieldUbicacionLibroFisico.clear();
        textFieldNumeroPaginasLibroFisico.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void obtenerLibrosDigitales() {
        listLibrosFisicos.addAll(gestionLibroFisicoController.obtenerListaLibrosFisicos());
    }

    @FXML
    private void listenerSelection() {
        tablaLibrosFisicos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedLibroFisico = newSelection;
            mostrarDetalleLibro(selectedLibroFisico);
        });
    }
}

