package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;

import co.edu.uniquindio.poo.bibliotecajfx.controller.GestionVisitanteController;
import co.edu.uniquindio.poo.bibliotecajfx.model.Visitante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionVisitanteViewController {
    GestionVisitanteController gestionVisitanteController;
    ObservableList<Visitante> listVisitantes = FXCollections.observableArrayList();
    Visitante selectedVisitante;
    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Visitante> tablaVisitantes;

    @FXML
    private TableColumn<Visitante, String> columnaNombre;

    @FXML
    private TableColumn<Visitante, String> columnaIdentificacion;

    @FXML
    private TableColumn<Visitante, Integer> columnaEdad;

    @FXML
    private TableColumn<Visitante, String> columnaCorreo;

    @FXML
    private TableColumn<Visitante, String> columnaTelefono;

    @FXML
    private TableColumn<Visitante, String> columnaContrasenia;


    @FXML
    private TextField textFieldNombreVisitante;

    @FXML
    private TextField textFieldIdentificacionVisitante;

    @FXML
    private TextField textFieldEdadVisitante;

    @FXML
    private TextField textFieldCorreoVisitante;

    @FXML
    private TextField textFieldTelefonoVisitante;

    @FXML
    private TextField textFieldContraseniaVisitante;


    @FXML
    private Button btnActualizarVisitante;

    @FXML
    private Button btnAnadirVisitante;

    @FXML
    private Button btnEliminarVisitante;
    @FXML
    private Button btnLimpiarCeldas;

    @FXML
    private Button btnRegresar;


    @FXML
    void onAnadirVisitante() {
        agregarVisitante();
    }

    @FXML
    void onActualizarVisitante() {
        actualizarVisitante();
    }

    @FXML
    void onEliminarVisitante() {
        eliminarVisitante();
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


        obtenerVisitantes();


        tablaVisitantes.getItems().clear();


        tablaVisitantes.setItems(listVisitantes);


        listenerSelection();
    }

    @FXML
    public void setApp(App app) {
        this.app = app;
        gestionVisitanteController = new GestionVisitanteController(App.bibliotecario);
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

    private void mostrarDetalleVisitante(Visitante visitante) {
        if (visitante != null) {
            textFieldNombreVisitante.setText(visitante.getNombre());
            textFieldIdentificacionVisitante.setText(visitante.getIdentificacion());
            textFieldEdadVisitante.setText(String.valueOf(visitante.getEdad()));
            textFieldCorreoVisitante.setText(visitante.getCorreo());
            textFieldTelefonoVisitante.setText(visitante.getTelefono());
            textFieldContraseniaVisitante.setText(visitante.getContrasenia());
        }
    }

    @FXML
    private void agregarVisitante() {
        if (textFieldNombreVisitante.getText().isEmpty() ||
                textFieldIdentificacionVisitante.getText().isEmpty() ||
                textFieldEdadVisitante.getText().isEmpty() ||
                textFieldCorreoVisitante.getText().isEmpty() ||
                textFieldTelefonoVisitante.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos deben estar llenos.");
            return;
        }


        Visitante visitante = new Visitante(
                textFieldNombreVisitante.getText(),
                textFieldIdentificacionVisitante.getText(),
                Integer.parseInt(textFieldEdadVisitante.getText()),
                textFieldCorreoVisitante.getText(),
                textFieldTelefonoVisitante.getText(),
                textFieldContraseniaVisitante.getText()

        );

        listVisitantes.add(visitante);
        tablaVisitantes.setItems(listVisitantes);
        gestionVisitanteController.crearVisitante(visitante);
        limpiarCampos();
    }

    @FXML
    private void actualizarVisitante() {
        Visitante visitanteSeleccionado = tablaVisitantes.getSelectionModel().getSelectedItem();
        if (visitanteSeleccionado == null) {
            mostrarAlerta("Advertencia", "Debe seleccionar un Visitante para actualizar.");
            return;
        }

        String tituloAnterior = visitanteSeleccionado.getNombre();
        visitanteSeleccionado.setNombre(textFieldNombreVisitante.getText());
        visitanteSeleccionado.setIdentificacion(textFieldIdentificacionVisitante.getText());
        visitanteSeleccionado.setEdad(Integer.parseInt(textFieldEdadVisitante.getText()));
        visitanteSeleccionado.setCorreo(textFieldCorreoVisitante.getText());
        visitanteSeleccionado.setTelefono(textFieldTelefonoVisitante.getText());
        visitanteSeleccionado.setContrasenia(textFieldContraseniaVisitante.getText());
        gestionVisitanteController.actualizarVisitante(tituloAnterior, visitanteSeleccionado);

        tablaVisitantes.refresh();
        limpiarCampos();
    }

    @FXML
    private void eliminarVisitante() {
        Visitante visitanteSeleccionado = tablaVisitantes.getSelectionModel().getSelectedItem();
        if (visitanteSeleccionado != null) {
            listVisitantes.remove(visitanteSeleccionado);
            gestionVisitanteController.eliminarVisitante(visitanteSeleccionado.getIdentificacion());
        } else {
            mostrarAlerta("Advertencia", "Debe seleccionar un Visitante para eliminar.");
        }
    }


    private void limpiarCampos() {
        textFieldNombreVisitante.clear();
        textFieldIdentificacionVisitante.clear();
        textFieldEdadVisitante.clear();
        textFieldCorreoVisitante.clear();
        textFieldTelefonoVisitante.clear();
        textFieldContraseniaVisitante.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void obtenerVisitantes() {
        listVisitantes.addAll(gestionVisitanteController.obtenerListaVisitantes());
    }

    @FXML
    private void listenerSelection() {
        tablaVisitantes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVisitante = newSelection;
            mostrarDetalleVisitante(selectedVisitante);
        });
    }
}
