package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.GestionEstudianteController;
import co.edu.uniquindio.poo.bibliotecajfx.model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionEstudianteViewController {
   GestionEstudianteController gestionEstudianteController;
    ObservableList<Estudiante> listEstudiantes = FXCollections.observableArrayList();
    Estudiante selectedEstudiante;
    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> columnaNombre;

    @FXML
    private TableColumn<Estudiante, String> columnaIdentificacion;

    @FXML
    private TableColumn<Estudiante, Integer> columnaEdad;

    @FXML
    private TableColumn<Estudiante, String> columnaCorreo;

    @FXML
    private TableColumn<Estudiante, String> columnaTelefono;

    @FXML
    private TableColumn<Estudiante, String> columnaContrasenia;


    @FXML
    private TextField textFieldNombreEstudiante;

    @FXML
    private TextField textFieldIdentificacionEstudiante;

    @FXML
    private TextField textFieldEdadEstudiante;

    @FXML
    private TextField textFieldCorreoEstudiante;

    @FXML
    private TextField textFieldTelefonoEstudiante;

    @FXML
    private TextField textFieldContraseniaEstudiante;


    @FXML
    private Button btnActualizarEstudiante;

    @FXML
    private Button btnAnadirEstudiante;

    @FXML
    private Button btnEliminarEstudiante;
    @FXML
    private Button btnLimpiarCeldas;

    @FXML
    private Button btnRegresar;


    @FXML
    void onAnadirEstudiante() {
        agregarBibliotecario();
    }

    @FXML
    void onActualizarEstudiante() {
        actualizarBibliotecario();
    }

    @FXML
    void onEliminarEstudiante() {
        eliminarBibliotecario();
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


        obtenerBibliotecarios();


        tablaEstudiantes.getItems().clear();


        tablaEstudiantes.setItems(listEstudiantes);


        listenerSelection();
    }
    @FXML
    public void setApp(App app) {
        this.app= app;
        gestionEstudianteController = new GestionEstudianteController(App.bibliotecario);
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

    }

    private void mostrarDetalleEstudiante(Estudiante estudiante) {
        if (estudiante!= null) {
            textFieldNombreEstudiante.setText(estudiante.getNombre());
            textFieldIdentificacionEstudiante.setText(estudiante.getIdentificacion());
            textFieldEdadEstudiante.setText(String.valueOf(estudiante.getEdad()));
            textFieldCorreoEstudiante.setText(estudiante.getCorreo());
            textFieldTelefonoEstudiante.setText(estudiante.getTelefono());
            textFieldContraseniaEstudiante.setText(estudiante.getContrasenia());
        }
    }

    @FXML
    private void agregarBibliotecario() {
        if (textFieldNombreEstudiante.getText().isEmpty() ||
                textFieldIdentificacionEstudiante.getText().isEmpty() ||
                textFieldEdadEstudiante.getText().isEmpty() ||
                textFieldCorreoEstudiante.getText().isEmpty() ||
                textFieldTelefonoEstudiante.getText().isEmpty() ) {
            mostrarAlerta("Error", "Todos los campos deben estar llenos.");
            return;
        }


        Estudiante estudiante= new Estudiante(
                textFieldNombreEstudiante.getText(),
                textFieldIdentificacionEstudiante.getText(),
                Integer.parseInt(textFieldEdadEstudiante.getText()),
                textFieldCorreoEstudiante.getText(),
                textFieldTelefonoEstudiante.getText(),
                textFieldContraseniaEstudiante.getText()
                
        );

        listEstudiantes.add(estudiante);
        tablaEstudiantes.setItems(listEstudiantes);
        gestionEstudianteController.crearEstudiante(estudiante);
        limpiarCampos();
    }

    @FXML
    private void actualizarBibliotecario() {
        Estudiante estudianteSeleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (estudianteSeleccionado == null) {
            mostrarAlerta("Advertencia", "Debe seleccionar un Estudiante para actualizar.");
            return;
        }

        String tituloAnterior = estudianteSeleccionado.getNombre();
        estudianteSeleccionado.setNombre(textFieldNombreEstudiante.getText());
        estudianteSeleccionado.setIdentificacion(textFieldIdentificacionEstudiante.getText());
        estudianteSeleccionado.setEdad(Integer.parseInt(textFieldEdadEstudiante.getText()));
        estudianteSeleccionado.setCorreo(textFieldCorreoEstudiante.getText());
        estudianteSeleccionado.setTelefono(textFieldTelefonoEstudiante.getText());
        estudianteSeleccionado.setContrasenia(textFieldContraseniaEstudiante.getText());
        gestionEstudianteController.actualizarEstudiante(tituloAnterior, estudianteSeleccionado);

        tablaEstudiantes.refresh();
        limpiarCampos();
    }

    @FXML
    private void eliminarBibliotecario() {
        Estudiante estudianteSeleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (estudianteSeleccionado != null) {
            listEstudiantes.remove(estudianteSeleccionado);
            gestionEstudianteController.eliminarEstudiante(estudianteSeleccionado.getIdentificacion());
        } else {
            mostrarAlerta("Advertencia", "Debe seleccionar un estudiante para eliminar.");
        }
    }


    private void limpiarCampos() {
        textFieldNombreEstudiante.clear();
        textFieldIdentificacionEstudiante.clear();
        textFieldEdadEstudiante.clear();
        textFieldCorreoEstudiante.clear();
        textFieldTelefonoEstudiante.clear();
        textFieldContraseniaEstudiante.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void obtenerBibliotecarios() {
        listEstudiantes.addAll(gestionEstudianteController.obtenerListaEstudiantes());
    }

    @FXML
    private void listenerSelection() {
        tablaEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEstudiante = newSelection;
            mostrarDetalleEstudiante(selectedEstudiante);
        });
    }
}
