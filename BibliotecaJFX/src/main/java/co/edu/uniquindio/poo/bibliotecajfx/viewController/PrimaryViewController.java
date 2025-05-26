package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryViewController {
    @FXML
    private ResourceBundle resources;
    App app;
    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    void onOpenCrudSeleccionGrupoUsuario() {
        app.openCrudSeleccionGrupoUsuario();
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {

    }

}
