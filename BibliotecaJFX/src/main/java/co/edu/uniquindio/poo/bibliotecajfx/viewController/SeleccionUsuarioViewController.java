package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SeleccionUsuarioViewController {
    @FXML
    private ResourceBundle resources;
    App app;
    @FXML
    private URL location;

    @FXML
    private Button btnInicioDocente;

    @FXML
    private Button btnInicioEstudiante;

    @FXML
    private Button btnInicioVisitante;

    @FXML
    void onOpenCrudIngresarDocente() {
        app.openCrudInicioSesionDocente();
    }
    @FXML
    void onOpenCrudIngresarEstudiante(){
        app.openCrudInicioSesionEstudiante();
    }
    @FXML
    void onOpenCrudIngresarVisitante() {
        app.openCrudInicioSesionVisitante();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
