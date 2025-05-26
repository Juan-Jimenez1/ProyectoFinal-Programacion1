package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DocenteViewController {
    App app;
    @FXML
    private URL url;

    @FXML
    private ResourceBundle resourceBundle;
    @FXML
    private Button btnVerLibrosDocente;

    @FXML
    private Button btnVerHistorialPrestamosDocente;

    @FXML
    private Button btnVerPrestamosActivosDocente;

    @FXML
    private Button btnCerrarSesionDocente;

    @FXML
    void onOpenCrudVerLibrosDocente() {
        app.openCrudMostrarLibrosDocente();

    }

    @FXML
    void onOpenCrudVerHistorialPrestamosDocente() {
         app.openCrudHistorialPrestamosDocente();
    }

    @FXML
    void onOpenCrudVerPrestamosActivosDocente() {
       app.openCrudMostrarPrestamosActivosDocente();
    }

    @FXML
    void onCerrarSesionDocente() {
        app.openCrudPrimary();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
