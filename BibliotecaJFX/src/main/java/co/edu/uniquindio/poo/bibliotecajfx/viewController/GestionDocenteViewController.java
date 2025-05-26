package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.GestionDocenteController;
import co.edu.uniquindio.poo.bibliotecajfx.model.Docente;
import co.edu.uniquindio.poo.bibliotecajfx.model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionDocenteViewController {
    GestionDocenteController gestionDocenteController;
    ObservableList<Docente> listDocentes = FXCollections.observableArrayList();
    Docente selectedDocente;
    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Docente> tablaDocentes;

    @FXML
    private TableColumn<Docente, String> columnaNombre;

    @FXML
    private TableColumn<Docente, String> columnaIdentificacion;

    @FXML
    private TableColumn<Docente, Integer> columnaEdad;

    @FXML
    private TableColumn<Docente, String> columnaCorreo;

    @FXML
    private TableColumn<Docente, String> columnaTelefono;

    @FXML
    private TableColumn<Docente, String> columnaContrasenia;


    @FXML
    private TextField textFieldNombreDocente;

    @FXML
    private TextField textFieldIdentificacionDocente;

    @FXML
    private TextField textFieldEdadDocente;

    @FXML
    private TextField textFieldCorreoDocente;

    @FXML
    private TextField textFieldTelefonoDocente;

    @FXML
    private TextField textFieldContraseniaDocente;


    @FXML
    private Button btnActualizarDocente;

    @FXML
    private Button btnAnadirDocente;

    @FXML
    private Button btnEliminarDocente;
    @FXML
    private Button btnLimpiarCeldas;

    @FXML
    private Button btnRegresar;


    @FXML
    void onAnadirDocente() {
        agregarDocente();
    }

    @FXML
    void onActualizarDocente() {
        actualizarDocente();
    }

    @FXML
    void onEliminarDocente() {
        eliminarDocente();
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


        tablaDocentes.getItems().clear();


        tablaDocentes.setItems(listDocentes);


        listenerSelection();
    }
    @FXML
    public void setApp(App app) {
        this.app= app;
        gestionDocenteController = new GestionDocenteController(App.bibliotecario);
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

    private void mostrarDetalleDocente(Docente docente) {
        if (docente != null) {
            textFieldNombreDocente.setText(docente.getNombre());
            textFieldIdentificacionDocente.setText(docente.getIdentificacion());
            textFieldEdadDocente.setText(String.valueOf(docente.getEdad()));
            textFieldCorreoDocente.setText(docente.getCorreo());
            textFieldTelefonoDocente.setText(docente.getTelefono());
            textFieldContraseniaDocente.setText(docente.getContrasenia());
        }
    }

    @FXML
    private void agregarDocente() {
        if (textFieldNombreDocente.getText().isEmpty() ||
                textFieldIdentificacionDocente.getText().isEmpty() ||
                textFieldEdadDocente.getText().isEmpty() ||
                textFieldCorreoDocente.getText().isEmpty() ||
                textFieldTelefonoDocente.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos deben estar llenos.");
            return;
        }


        Docente docente = new Docente(
                textFieldNombreDocente.getText(),
                textFieldIdentificacionDocente.getText(),
                Integer.parseInt(textFieldEdadDocente.getText()),
                textFieldCorreoDocente.getText(),
                textFieldTelefonoDocente.getText(),
                textFieldContraseniaDocente.getText()

        );

        listDocentes.add(docente);
        tablaDocentes.setItems(listDocentes);
        gestionDocenteController.crearDocente(docente);
        limpiarCampos();
    }

    @FXML
    private void actualizarDocente() {
        Docente docenteSeleccionado = tablaDocentes.getSelectionModel().getSelectedItem();
        if (docenteSeleccionado == null) {
            mostrarAlerta("Advertencia", "Debe seleccionar un Docente para actualizar.");
            return;
        }

        String tituloAnterior = docenteSeleccionado.getNombre();
        docenteSeleccionado.setNombre(textFieldNombreDocente.getText());
        docenteSeleccionado.setIdentificacion(textFieldIdentificacionDocente.getText());
        docenteSeleccionado.setEdad(Integer.parseInt(textFieldEdadDocente.getText()));
        docenteSeleccionado.setCorreo(textFieldCorreoDocente.getText());
        docenteSeleccionado.setTelefono(textFieldTelefonoDocente.getText());
        docenteSeleccionado.setContrasenia(textFieldContraseniaDocente.getText());
        gestionDocenteController.actualizarDocente(tituloAnterior, docenteSeleccionado);

        tablaDocentes.refresh();
        limpiarCampos();
    }

    @FXML
    private void eliminarDocente() {
        Docente docenteSeleccionado = tablaDocentes.getSelectionModel().getSelectedItem();
        if (docenteSeleccionado != null) {
            listDocentes.remove(docenteSeleccionado);
            gestionDocenteController.eliminarDocente(docenteSeleccionado.getIdentificacion());
        } else {
            mostrarAlerta("Advertencia", "Debe seleccionar un Docente para eliminar.");
        }
    }


    private void limpiarCampos() {
        textFieldNombreDocente.clear();
        textFieldIdentificacionDocente.clear();
        textFieldEdadDocente.clear();
        textFieldCorreoDocente.clear();
        textFieldTelefonoDocente.clear();
        textFieldContraseniaDocente.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void obtenerBibliotecarios() {
        listDocentes.addAll(gestionDocenteController.obtenerListaDocentes());
    }

    @FXML
    private void listenerSelection() {
        tablaDocentes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedDocente = newSelection;
            mostrarDetalleDocente(selectedDocente);
        });
    }
}
