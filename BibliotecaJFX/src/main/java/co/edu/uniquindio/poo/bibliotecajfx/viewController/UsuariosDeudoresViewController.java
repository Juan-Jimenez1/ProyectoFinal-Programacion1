package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.UsuarioConMasPrestamosController;
import co.edu.uniquindio.poo.bibliotecajfx.controller.UsuariosDeudoresController;
import co.edu.uniquindio.poo.bibliotecajfx.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuariosDeudoresViewController {
    UsuariosDeudoresController usuariosDeudoresController;
    ObservableList<Usuario> usuariosDeudores = FXCollections.observableArrayList();
    App app;

    @FXML
    private URL url;

    @FXML
    private ResourceBundle resourceBundle;


    @FXML
    private TableView<Usuario> tablaUsuariosDeudores;

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
        app.openCrudBibliotecario();
    }

    @FXML
    void initView() {


        initDataBinding();


        obtenerUsuario();


        tablaUsuariosDeudores.getItems().clear();


        tablaUsuariosDeudores.setItems(usuariosDeudores);


    }

    @FXML
    public void setApp(App app) {
        this.app = app;
        usuariosDeudoresController= new UsuariosDeudoresController(App.bibliotecario);
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
        usuariosDeudores.addAll(usuariosDeudoresController.usuariosDeudores());
    }


}


