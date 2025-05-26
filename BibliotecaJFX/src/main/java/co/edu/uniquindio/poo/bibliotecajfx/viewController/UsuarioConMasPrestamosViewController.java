package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.UsuarioConMasPrestamosController;
import co.edu.uniquindio.poo.bibliotecajfx.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioConMasPrestamosViewController {
    UsuarioConMasPrestamosController usuarioConMasPrestamosController;
    ObservableList<Usuario>usuarioConMasPrestamos = FXCollections.observableArrayList();
    App app;
    
    @FXML
    private URL url;
    
    @FXML
    private ResourceBundle resourceBundle;


    @FXML
    private TableView<Usuario> tablaUsuarioConMasPrestamos;

    @FXML
    private TableColumn<Usuario, String> columnaNombre;

    @FXML
    private TableColumn<Usuario, String> columnaIdentificacion;

    @FXML
    private TableColumn<Usuario, Integer> columnaEdad;

    @FXML
    private TableColumn<Usuario, String> columnaCorreo;

    @FXML
    private TableColumn<Usuario, String> columnaTelefono;

    @FXML
    private TableColumn<Usuario, String> columnaContrasenia;

    @FXML
    private Button btnRegresar;

    @FXML
    private void onRegresar() {
        app.openCrudAdministrador();
    }

    @FXML
    void initView() {


        initDataBinding();


        obtenerUsuario();


        tablaUsuarioConMasPrestamos.getItems().clear();


        tablaUsuarioConMasPrestamos.setItems(usuarioConMasPrestamos);


    }

    @FXML
    public void setApp(App app) {
        this.app = app;
        usuarioConMasPrestamosController = new UsuarioConMasPrestamosController(App.administrador);
        initView();
    }

    @FXML
    public void initDataBinding() {
        columnaNombre.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getNombre()));
        columnaIdentificacion.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getIdentificacion()));
        columnaEdad.setCellValueFactory(celda -> new javafx.beans.property.SimpleIntegerProperty(celda.getValue().getEdad()).asObject());
        columnaCorreo.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getCorreo()));
        columnaTelefono.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getTelefono()));
        columnaContrasenia.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty((celda.getValue().getContrasenia())));

    }

    @FXML
    private void obtenerUsuario() {
        usuarioConMasPrestamos.addAll(usuarioConMasPrestamosController.mostrarUsuarioConMasPrestamos());
    }


}
