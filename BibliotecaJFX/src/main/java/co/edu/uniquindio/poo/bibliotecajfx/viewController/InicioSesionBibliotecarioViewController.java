package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.InicioSesionBibliotecarioController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioSesionBibliotecarioViewController {
    InicioSesionBibliotecarioController inicioSesionBibliotecarioController;
    @FXML
    private App app;
    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private TextField textFieldCredencialBibliotecario;

    @FXML
    private TextField textFieldContraseniaBibliotecario;

    @FXML
    private Button btnAccederBibliotecario;

    @FXML
    private Button btnRegresar;

    @FXML
    void onRegresar() {
        app.openCrudPrimary();
    }

    @FXML
    void onAcceder() {
        String credencial = textFieldCredencialBibliotecario.getText();
        String contrasenia = textFieldContraseniaBibliotecario.getText();
        if (credencial.isEmpty() || contrasenia.isEmpty()) {
            mostrarAlerta("Error","Todos los campos deben estar llenos");
        }
        if (inicioSesionBibliotecarioController.iniciarSesionBibliotecario(credencial, contrasenia)) {
            app.openCrudBibliotecario();
        }
    }
    public void setApp(App app) {
        this.app = app;
        inicioSesionBibliotecarioController = new InicioSesionBibliotecarioController(App.biblioteca);

    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
