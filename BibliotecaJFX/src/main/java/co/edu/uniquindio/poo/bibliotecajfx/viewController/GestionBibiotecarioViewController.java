package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.GestionBibliotecarioController;
import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionBibiotecarioViewController {
    GestionBibliotecarioController gestionBibliotecarioController;
    ObservableList<Bibliotecario> listBibliotecarios = FXCollections.observableArrayList();
    Bibliotecario selectedBibliotecario;
    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Bibliotecario> tablaBibliotecarios;

    @FXML
    private TableColumn<Bibliotecario, String> columnaNombre;

    @FXML
    private TableColumn<Bibliotecario, String> columnaIdentificacion;

    @FXML
    private TableColumn<Bibliotecario, Integer> columnaEdad;

    @FXML
    private TableColumn<Bibliotecario, String> columnaCorreo;

    @FXML
    private TableColumn<Bibliotecario, String> columnaTelefono;

    @FXML
    private TableColumn<Bibliotecario, String> columnaContrasenia;

    @FXML
    private TableColumn<Bibliotecario, String> columnaCredencial;

    @FXML
    private TextField textFieldNombreBibliotecario;

    @FXML
    private TextField textFieldIdentificacionBibliotecario;

    @FXML
    private TextField textFieldEdadBibliotecario;

    @FXML
    private TextField textFieldCorreoBibliotecario;

    @FXML
    private TextField textFieldTelefonoBibliotecario;

    @FXML
    private TextField textFieldContraseniaBibliotecario;
    @FXML
    private TextField textFieldCredencialBibliotecario;


    @FXML
    private Button btnActualizarBibliotecario;

    @FXML
    private Button btnAnadirBibliotecario;

    @FXML
    private Button btnEliminarBibliotecario;
    @FXML
    private Button btnLimpiarCeldas;

    @FXML
    private Button btnRegresar;


    @FXML
    void onAnadirBibliotecario() {
        agregarBibliotecario();
    }

    @FXML
    void onActualizarBibliotecario() {
        actualizarBibliotecario();
    }

    @FXML
    void onEliminarBibliotecario() {
        eliminarBibliotecario();
    }

    @FXML
    void onRegresar() {
       app.openCrudAdministrador();
    }

    @FXML
    void onLimpiarCampos() {
        limpiarCampos();
    }

    @FXML
    void initView() {


        initDataBinding();


        obtenerBibliotecarios();


        tablaBibliotecarios.getItems().clear();


        tablaBibliotecarios.setItems(listBibliotecarios);


        listenerSelection();
    }
    @FXML
    public void setApp(App app) {
        this.app= app;
        gestionBibliotecarioController = new GestionBibliotecarioController(App.administrador);
        initView();
    }

    @FXML
    public void initDataBinding() {
        columnaNombre.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getNombre()));
        columnaIdentificacion.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getIdentificacion()));
        columnaEdad.setCellValueFactory(celda -> new javafx.beans.property.SimpleIntegerProperty(celda.getValue().getEdad()).asObject());
        columnaCorreo.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getCorreo()));
        columnaTelefono.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getTelefono()));
        columnaContrasenia.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty((celda.getValue().getContrasenia())));
        columnaCredencial.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getCredencial()));

    }

    private void mostrarDetalleBibliotecario(Bibliotecario bibliotecario) {
        if (bibliotecario!= null) {
            textFieldNombreBibliotecario.setText(bibliotecario.getNombre());
            textFieldIdentificacionBibliotecario.setText(bibliotecario.getIdentificacion());
            textFieldEdadBibliotecario.setText(String.valueOf(bibliotecario.getEdad()));
            textFieldCorreoBibliotecario.setText(bibliotecario.getCorreo());
            textFieldTelefonoBibliotecario.setText(bibliotecario.getTelefono());
            textFieldContraseniaBibliotecario.setText(bibliotecario.getContrasenia());
            textFieldCredencialBibliotecario.setText(bibliotecario.getCredencial());
        }
    }

    @FXML
    private void agregarBibliotecario() {
        if (textFieldNombreBibliotecario.getText().isEmpty() ||
                textFieldIdentificacionBibliotecario.getText().isEmpty() ||
                textFieldEdadBibliotecario.getText().isEmpty() ||
                textFieldCorreoBibliotecario.getText().isEmpty() ||
                textFieldTelefonoBibliotecario.getText().isEmpty() || textFieldCredencialBibliotecario.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos deben estar llenos.");
            return;
        }


        Bibliotecario bibliotecario = new Bibliotecario(
                textFieldNombreBibliotecario.getText(),
                textFieldIdentificacionBibliotecario.getText(),
                Integer.parseInt(textFieldEdadBibliotecario.getText()),
                textFieldCorreoBibliotecario.getText(),
                textFieldTelefonoBibliotecario.getText(),
                textFieldContraseniaBibliotecario.getText(),
                textFieldCredencialBibliotecario.getText(),
                App.biblioteca
        );

        listBibliotecarios.add(bibliotecario);
        tablaBibliotecarios.setItems(listBibliotecarios);
        gestionBibliotecarioController.crearBibliotecario(bibliotecario);
        limpiarCampos();
    }

    @FXML
    private void actualizarBibliotecario() {
        Bibliotecario bibliotecarioSeleccionado = tablaBibliotecarios.getSelectionModel().getSelectedItem();
        if (bibliotecarioSeleccionado == null) {
            mostrarAlerta("Advertencia", "Debe seleccionar un Bibliotecario para actualizar.");
            return;
        }

        String tituloAnterior = bibliotecarioSeleccionado.getNombre();
        bibliotecarioSeleccionado.setNombre(textFieldNombreBibliotecario.getText());
        bibliotecarioSeleccionado.setIdentificacion(textFieldIdentificacionBibliotecario.getText());
        bibliotecarioSeleccionado.setEdad(Integer.parseInt(textFieldEdadBibliotecario.getText()));
        bibliotecarioSeleccionado.setCorreo(textFieldCorreoBibliotecario.getText());
        bibliotecarioSeleccionado.setTelefono(textFieldTelefonoBibliotecario.getText());
        bibliotecarioSeleccionado.setContrasenia(textFieldContraseniaBibliotecario.getText());
        gestionBibliotecarioController.actualizarBibliotecario(tituloAnterior, bibliotecarioSeleccionado);

        tablaBibliotecarios.refresh();
        limpiarCampos();
    }

    @FXML
    private void eliminarBibliotecario() {
        Bibliotecario bibliotecarioSeleccionado = tablaBibliotecarios.getSelectionModel().getSelectedItem();
        if (bibliotecarioSeleccionado != null) {
            listBibliotecarios.remove(bibliotecarioSeleccionado);
            gestionBibliotecarioController.eliminarBibliotecario(bibliotecarioSeleccionado.getIdentificacion());
        } else {
            mostrarAlerta("Advertencia", "Debe seleccionar un Bibliotecario para eliminar.");
        }
    }


    private void limpiarCampos() {
        textFieldNombreBibliotecario.clear();
        textFieldIdentificacionBibliotecario.clear();
        textFieldEdadBibliotecario.clear();
        textFieldCorreoBibliotecario.clear();
        textFieldTelefonoBibliotecario.clear();
        textFieldCredencialBibliotecario.clear();
        textFieldContraseniaBibliotecario.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void obtenerBibliotecarios() {
        listBibliotecarios.addAll(gestionBibliotecarioController.obtenerListaBibliotecarios());
    }

    @FXML
    private void listenerSelection() {
        tablaBibliotecarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedBibliotecario = newSelection;
            mostrarDetalleBibliotecario(selectedBibliotecario);
        });
    }

}



