package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.GestionLibroReferenciaController;
import co.edu.uniquindio.poo.bibliotecajfx.model.EstadoLibro;
import co.edu.uniquindio.poo.bibliotecajfx.model.LibroReferencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionLibroReferenciaViewController {
    GestionLibroReferenciaController gestionLibroReferenciaController;
    ObservableList<LibroReferencia> listaLibrosReferencia = FXCollections.observableArrayList();
    LibroReferencia selectedLibroReferencia;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<LibroReferencia> tablaLibrosReferencia;

    @FXML
    private TableColumn<LibroReferencia, String> columnaTitulo;

    @FXML
    private TableColumn<LibroReferencia, String> columnaAutor;

    @FXML
    private TableColumn<LibroReferencia, String> columnaGenero;

    @FXML
    private TableColumn<LibroReferencia, Integer> columnaAnioPublicacion;



    @FXML
    private TextField textFieldTitulo;

    @FXML
    private TextField textFieldAutor;

    @FXML
    private TextField textFieldGenero;

    @FXML
    private TextField textFieldAnioPublicacion;

    @FXML
    private Button btnAnadirLibroReferencia;

    @FXML
    private Button btnActualizarLibroReferencia;

    @FXML
    private Button btnEliminarLibroReferencia;
    @FXML
    private Button btnLimpiarSeleccion;

    @FXML
    private App app;
    @FXML
    void onAgregarLibroReferencia() {
        agregarLibroReferencia();
    }
    @FXML
    void onActualizarLibroReferencia() {
        actualizarLibroReferencia();
    }
    @FXML
    void onEliminarLibroReferencia() {
        eliminarLibroReferencia();
    }
    @FXML
    void onLimpiarSeleccion() {
        limpiarSeleccion();
    }

    @FXML
    void onRegresar() {
        app.openCrudBibliotecario();
    }

    @FXML
    private Button btnRegresar;

    @FXML
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerLibrosReferencia();

        // Limpiar la tabla
        tablaLibrosReferencia.getItems().clear();

        // Agregar los elementos a la tabla
        tablaLibrosReferencia.setItems(listaLibrosReferencia);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }
    @FXML
    public void setApp(App app) {
        this.app= app;
        gestionLibroReferenciaController = new GestionLibroReferenciaController(App.bibliotecario);
        initView();
    }

    @FXML
    public void initDataBinding() {
        // Configurar columnas de la tabla
        columnaTitulo.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getTitulo()));
        columnaAutor.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getAutor()));
        columnaGenero.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getGenero()));
        columnaAnioPublicacion.setCellValueFactory(celda -> new javafx.beans.property.SimpleIntegerProperty(celda.getValue().getAnioPublicacion()).asObject());

    }
    @FXML
    private void listenerSelection() {
        tablaLibrosReferencia.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedLibroReferencia = newSelection;
            mostrarInformacionCliente(selectedLibroReferencia);
        });
    }
    @FXML
    private void mostrarInformacionCliente(LibroReferencia libroReferencia) {
        if (libroReferencia != null) {
            textFieldTitulo.setText(libroReferencia.getTitulo());
            textFieldAutor.setText(libroReferencia.getAutor());
            textFieldGenero.setText(libroReferencia.getGenero());
            textFieldAnioPublicacion.setText(String.valueOf(libroReferencia.getAnioPublicacion()));
        }
    }


    @FXML
    private void agregarLibroReferencia() {
        if (textFieldTitulo.getText().isEmpty() ||textFieldAutor.getText().isEmpty() ||textFieldGenero.getText().isEmpty() ||textFieldAnioPublicacion.getText().isEmpty()) {
            mostrarAlerta("Error","Todos los campos deben estar llenos");
            return;
        }
        LibroReferencia libroReferencia = new LibroReferencia(textFieldTitulo.getText(),textFieldAutor.getText(),textFieldGenero.getText(),EstadoLibro.REFERENCIA,Integer.parseInt(textFieldAnioPublicacion.getText()) );
        gestionLibroReferenciaController.crearLibroReferencia(libroReferencia);
        listaLibrosReferencia.add(libroReferencia);
        limpiarCamposLibroReferencia();

    }
    @FXML
    private void obtenerLibrosReferencia() {
        listaLibrosReferencia.addAll(gestionLibroReferenciaController.obtenerListaLibrosReferencia());
    }

    @FXML
    private void actualizarLibroReferencia() {
        LibroReferencia libroSeleccionado = tablaLibrosReferencia.getSelectionModel().getSelectedItem();
        if(libroSeleccionado==null){
            mostrarAlerta("Error","Debe seleccionar un libro para actualizar");
            return;
        }
        libroSeleccionado.setTitulo(textFieldTitulo.getText());
        libroSeleccionado.setAutor(textFieldAutor.getText());
        libroSeleccionado.setGenero(textFieldGenero.getText());
        libroSeleccionado.setAnioPublicacion(Integer.parseInt(textFieldAnioPublicacion.getText()));
        tablaLibrosReferencia.refresh();
        gestionLibroReferenciaController.actualizarLibroReferencia(libroSeleccionado.getTitulo(), libroSeleccionado);
        limpiarCamposLibroReferencia();


    }

    @FXML
    private void eliminarLibroReferencia() {
        LibroReferencia libroSeleccionado = tablaLibrosReferencia.getSelectionModel().getSelectedItem();
        if(libroSeleccionado==null){
            mostrarAlerta("Error","Debe seleccionar un libro para eliminar");
            return;
        }
        listaLibrosReferencia.remove(libroSeleccionado);
        gestionLibroReferenciaController.eliminarLibroReferencia(libroSeleccionado.getTitulo());

    }
    @FXML
    private void limpiarSeleccion() {
        tablaLibrosReferencia.getSelectionModel().clearSelection();
        limpiarCamposLibroReferencia();
    }
    @FXML
    private void limpiarCamposLibroReferencia() {
        textFieldTitulo.clear();
        textFieldAutor.clear();
        textFieldGenero.clear();
        textFieldAnioPublicacion.clear();
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
