package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SeleccionGrupoUsuarioViewController {
    @FXML
    private ResourceBundle resources;
    App app;
    @FXML
    private URL location;

    @FXML
    private Button btnSeleccionUsuario;

    @FXML
    private Button btnSeleccionEmpleado;

    @FXML
    void onOpenCrudSeleccionUsuario() {
        app.openCrudSeleccionUsuario();
    }

    @FXML
    void onOpenCrudSeleccionEmpleado() {
        app.openCrudSeleccionEmpleado();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
