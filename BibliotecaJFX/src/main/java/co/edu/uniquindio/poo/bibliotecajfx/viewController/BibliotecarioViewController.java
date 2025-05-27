package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class BibliotecarioViewController {
    App app;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private Button btnGestionarEstudiantes;

    @FXML
    private Button btnGestionarDocentes;

    @FXML
    private Button btnGestionarVisitantes;

    @FXML
    private Button btnRealizarPrestamo;

    @FXML
    private Button btnRealizarDevolucion;

    @FXML
    private Button btnGestionarLibrosFisicos;

    @FXML
    private Button btnGestionarLibrosDigitales;

    @FXML
    private Button btnGestionarLibrosReferencia;

    @FXML
    private Button btnReporteLibroMasSolicitado;

    @FXML
    private Button btnReporteUsuariosDeudores;

    @FXML
    private Button btnReporteLibrosPrestados;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    void onCerrarSesion() {
      app.openCrudPrimary();
    }

    @FXML
    void onRealizarDevolucion() {

    }
    @FXML
    void onRealizarPrestamo() {

    }
    @FXML
    void onReportarLibroMasSolicitado() {
        app.openCrudLibroMasSolicitado();

    }
    @FXML
    void onReportarUsuariosDeudores() {

    }
    @FXML
    void onReportarLibrosPrestados() {

    }
    @FXML
    void onGestionarDocentes() {
        app.openCrudGestionDocente();

    }
    @FXML
    void onGestionarEstudiantes() {
        app.openCrudGestionEstudiante();

    }
    @FXML
    void onGestionarLibrosDigitales() {
         app.openCrudGestionarLibrosDigitales();
    }
    @FXML
    void onGestionarLibrosFisicos() {
        app.openCrudGestionarLibrosFisicos();
    }
    @FXML
    void onGestionarLibrosReferencia() {
        app.openCrudGestionarLibrosReferencia();

    }
    @FXML
    void onGestionarVisitantes() {
        app.openCrudGestionVisitante();

    }

    public void setApp(App app) {
        this.app = app;
    }

}
