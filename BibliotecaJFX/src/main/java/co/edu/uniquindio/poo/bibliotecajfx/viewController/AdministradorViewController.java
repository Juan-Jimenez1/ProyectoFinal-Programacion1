package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdministradorViewController {
    App app;

    @FXML
    private Button btnGestionarBibliotecarios;

    @FXML
    private Button btnReporteUsuarioConMasPrestamos;

    @FXML
    private Button btnReporteLibrosSinPrestamos;

    @FXML
    private Button btnReporteLibrosPrestadosEnMes;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    void onOpenCrudGestionarBibliotecarios() {
        app.openCrudGestionBibliotecario();

    }
    @FXML
    void onOpenCrudReporteUsuarioConMasPrestamos() {
        app.openCrudUsuarioConMasPrestamos();

    }
    @FXML
    void onOpenCrudReporteLibrosSinPrestamos() {
        app.openCrudLibrosSinPrestamos();

    }
    @FXML
    void onOpenCrudReporteLibrosPrestadosEnMes() {

    }
    @FXML
    void onCerrarSesion() {
        app.openCrudPrimary();
    }

    @FXML
    public void setApp(App app) {
        this.app = app;
    }
}
