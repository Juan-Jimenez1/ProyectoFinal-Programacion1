package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.PrestamoController;
import co.edu.uniquindio.poo.bibliotecajfx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class PrestamoViewController {
    PrestamoController prestamoController;
    ObservableList<Libro> listLibros = FXCollections.observableArrayList();
    Libro selectedLibro;
    App app;
    @FXML
    private TextField textFieldIdentificacionUsuario;


    @FXML
    private Button btnCrearPrestamo;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private TableView<Libro> tablaLibrosPrestamo;

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
    void onRegresar() {
        app.openCrudBibliotecario();
    }

    @FXML
    void onCrearPrestamo() {
        if(textFieldIdentificacionUsuario.getText().isEmpty()){
            mostrarAlerta("Error","Todos los campos deben estar llenos");
            return;
        }
        String identificacionUsuario = textFieldIdentificacionUsuario.getText();
        Libro libroSeleccionado = tablaLibrosPrestamo.getSelectionModel().getSelectedItem();
        Usuario usuario= prestamoController.buscarUsuario(identificacionUsuario);
        if(libroSeleccionado==null||usuario==null){
            mostrarAlerta("Error","El libro {o el usuario no existen");
            return;
        }
        if (usuario instanceof Estudiante estudiante){
            Prestamo prestamo= new Prestamo(LocalDate.now(),LocalDate.now().plusDays(estudiante.getMaxDiasPrestamo()),libroSeleccionado,estudiante);
            prestamoController.crearPrestamo(prestamo);
        }
        if(usuario instanceof Docente docente){
            Prestamo prestamo= new Prestamo(LocalDate.now(),LocalDate.now().plusDays(docente.getMaxDiasPrestamo()),libroSeleccionado,docente);
            prestamoController.crearPrestamo(prestamo);

        }
    }

    @FXML
    void limpiarCampos() {
        textFieldIdentificacionUsuario.clear();
    }


    @FXML
    public void setApp(App app) {
        this.app = app;
        prestamoController= new PrestamoController(App.bibliotecario);
        initView();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void initView() {
        initDataBinding();


        obtenerListaLibros();


        tablaLibrosPrestamo.getItems().clear();


        tablaLibrosPrestamo.setItems(listLibros);


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
        listLibros.addAll(prestamoController.listLibros());
    }
}


