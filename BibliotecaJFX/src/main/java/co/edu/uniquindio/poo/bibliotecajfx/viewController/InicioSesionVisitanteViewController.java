package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.InicioSesionEstudianteController;
import co.edu.uniquindio.poo.bibliotecajfx.controller.InicioSesionVisitanteController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioSesionVisitanteViewController {
    InicioSesionVisitanteController inicioSesionVisitanteController;
    App app;
    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private TextField textFieldIdentificacionVisitante;

    @FXML
    private TextField textFieldContraseniaVisitante;

    @FXML
    private Button btnAccederVisitante;

    @FXML
    private Button btnRegresar;

    @FXML
    void onRegresar() {
        app.openCrudPrimary();
    }

    @FXML
    void onAcceder() {
        String identificacion = textFieldIdentificacionVisitante.getText();
        String contrasenia = textFieldContraseniaVisitante.getText();
        if (identificacion.isEmpty() || contrasenia.isEmpty()) {
            mostrarAlerta("Error","Todos los campos deben estar llenos");
        }
        if (inicioSesionVisitanteController.iniciarSesionVisitante(identificacion, contrasenia)) {
            app.openCrudVisitante();
        }
    }
    public void setApp(App app) {
        this.app = app;
        inicioSesionVisitanteController = new InicioSesionVisitanteController(App.biblioteca);

    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
