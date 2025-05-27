package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.InicioSesionAdministradorController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioSesionAdministradorViewController {
    InicioSesionAdministradorController inicioSesionAdministradorController;
    @FXML
    private App app;
    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private TextField textFieldCredencial;

    @FXML
    private TextField textFieldContrasenia;

    @FXML
    private Button btnAcceder;

    @FXML
    private Button btnRegresar;

    @FXML
    void onRegresar() {
        app.openCrudPrimary();
    }

    @FXML
    void onAcceder() {
        String credencial = textFieldCredencial.getText();
        String contrasenia = textFieldContrasenia.getText();
        if(credencial.isEmpty() || contrasenia.isEmpty()){
            mostrarAlerta("ERROR","Todos los campos deben estar llenos");
            return;
        }
        if(inicioSesionAdministradorController.IniciarSesionAdministrador(credencial, contrasenia)){
            app.openCrudVerificarCodigoAdministrador();
        }
    }
    public void setApp(App app) {
        this.app = app;
        inicioSesionAdministradorController = new InicioSesionAdministradorController(App.biblioteca);
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
