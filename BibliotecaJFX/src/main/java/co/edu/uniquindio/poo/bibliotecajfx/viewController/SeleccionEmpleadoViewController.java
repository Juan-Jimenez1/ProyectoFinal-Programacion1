package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SeleccionEmpleadoViewController {
    @FXML
    private ResourceBundle resources;
    App app;
    @FXML
    private URL location;

    @FXML
    private Button btnInicioAdministrador;

    @FXML
    private Button btnInicioBibliotecario;


    @FXML
    void onOpenCrudIngresarAdministrador() {
        app.openCrudInicioSesionAdministrador();
    }
    @FXML
    void onOpenCrudIngresarBibliotecario(){
        app.openCrudInicioSesionBibliotecario();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
