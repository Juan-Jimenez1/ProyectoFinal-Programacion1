package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.InicioSesionDocenteController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioSesionDocenteViewController {
    InicioSesionDocenteController inicioSesionDocenteController;
    @FXML
    private App app;
    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private TextField textFieldIdentificacionDocente;

    @FXML
    private TextField textFieldContraseniaDocente;

    @FXML
    private Button btnAccederDocente;

    @FXML
    void onAcceder() {
        String identificacion = textFieldIdentificacionDocente.getText();
        String contrasenia = textFieldContraseniaDocente.getText();
        if (identificacion.isEmpty() || contrasenia.isEmpty()) {
            mostrarAlerta("Error","Todos los campos deben estar llenos");
        }
        if (inicioSesionDocenteController.iniciarSesionDocente(identificacion, contrasenia)) {
            app.openCrudDocente();
        }
    }
    public void setApp(App app) {
        this.app = app;
        inicioSesionDocenteController = new InicioSesionDocenteController(App.biblioteca);

    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}

