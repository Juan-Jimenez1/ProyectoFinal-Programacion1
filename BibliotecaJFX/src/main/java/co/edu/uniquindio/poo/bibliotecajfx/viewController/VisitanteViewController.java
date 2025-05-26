package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VisitanteViewController {
    App app;
    @FXML
    private Button btnVerLibrosVisitante;

    @FXML
    private Button btnCerrarSesionVisitante;


    @FXML
    void onOpenCrudVerLibrosVisitante() {
        app.openCrudMostrarLibrosVisitante();
    }
    @FXML
    void onCerrarSesionVisitante(){
        app.openCrudPrimary();
    }

    public void setApp(App app) {
        this.app = app;
    }

}
