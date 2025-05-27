package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.InicioSesionDocenteController;
import co.edu.uniquindio.poo.bibliotecajfx.controller.InicioSesionEstudianteController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioSesionEstudianteViewController {
    InicioSesionEstudianteController inicioSesionEstudianteController;
    App app;
    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private TextField textFieldIdentificacionEstudiante;

    @FXML
    private TextField textFieldContraseniaEstudiante;

    @FXML
    private Button btnAccederEstudiante;

    @FXML
    private Button btnRegresar;

    @FXML
    void onRegresar() {
        app.openCrudPrimary();
    }

    @FXML
    void onAcceder() {
        String identificacion = textFieldIdentificacionEstudiante.getText();
        String contrasenia = textFieldContraseniaEstudiante.getText();
        if (identificacion.isEmpty() || contrasenia.isEmpty()) {
            mostrarAlerta("Error","Todos los campos deben estar llenos");
        }
        if (inicioSesionEstudianteController.iniciarSesionEstudiante(identificacion, contrasenia)) {
            app.openCrudEstudiante();
        }
    }
    public void setApp(App app) {
        this.app = app;
        inicioSesionEstudianteController = new InicioSesionEstudianteController(App.biblioteca);

    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
