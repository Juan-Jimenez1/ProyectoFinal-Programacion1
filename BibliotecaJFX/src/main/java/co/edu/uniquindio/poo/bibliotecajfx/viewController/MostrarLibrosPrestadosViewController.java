package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.MostrarLibrosPrestadosController;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MostrarLibrosPrestadosViewController {
    MostrarLibrosPrestadosController mostrarlibrosPrestadosController;
    ObservableList<Libro> listLibrosDocente = FXCollections.observableArrayList();
    App app;
    @FXML
    private URL url;
    @FXML
    private ResourceBundle resourceBundle;
    @FXML
    private TableView<Libro> tablaLibrosPrestados;

    @FXML
    private TableColumn<Libro, String> columnaTitulo;

    @FXML
    private TableColumn<Libro, String> columnaAutor;

    @FXML
    private TableColumn<Libro, String> columnaGenero;

    @FXML
    private TableColumn<Libro, Integer> columnaAnioPublicacion;

    @FXML
    private TableColumn<Libro, String> columnaEstado;

    @FXML
    private Button btnRegresar;
    @FXML
    void onRegresar() {
        app.openCrudBibliotecario();
    }
    @FXML
    private void initView() {
        initDataBinding();


        obtenerListaLibros();


        tablaLibrosPrestados.getItems().clear();


        tablaLibrosPrestados.setItems(listLibrosDocente);


    }

    public void setApp(App app) {
        this.app = app;
        mostrarlibrosPrestadosController = new MostrarLibrosPrestadosController(App.bibliotecario);
        initView();
    }


    @FXML
    public void initDataBinding() {
        columnaTitulo.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getTitulo()));
        columnaAutor.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getAutor()));
        columnaGenero.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getGenero()));
        columnaEstado.setCellValueFactory(celda -> new javafx.beans.property.SimpleStringProperty(celda.getValue().getEstado().toString()));
        columnaAnioPublicacion.setCellValueFactory(celda -> new javafx.beans.property.SimpleIntegerProperty(celda.getValue().getAnioPublicacion()).asObject());

    }
    @FXML
    private void obtenerListaLibros() {
        listLibrosDocente.addAll(mostrarlibrosPrestadosController.librosPrestados());
    }
}

