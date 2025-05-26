package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class EstudianteViewController {
    App app;
    @FXML
    private URL url;

    @FXML
    private ResourceBundle resourceBundle;
    @FXML
    private Button btnVerLibrosEstudiante;

    @FXML
    private Button btnVerHistorialPrestamosEstudiante;

    @FXML
    private Button btnVerPrestamosActivosEstudiante;

    @FXML
    private Button btnCerrarSesionEstudiante;

    @FXML
    void onOpenCrudVerLibrosEstudiante() {
        app.openCrudMostrarLibrosEstudiante();

    }
    @FXML
    void onOpenCrudVerHistorialPrestamosEstudiante() {
        app.openCrudHistorialPrestamosEstudiante();

    }
    @FXML
    void onOpenCrudVerPrestamosActivosEstudiante() {
        app.openCrudMostrarPrestamosActivosEstudiante();

    }
    @FXML
    void onCerrarSesionEstudiante() {
        app.openCrudPrimary();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
