package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.MostrarPrestamosActivosDocenteController;
import co.edu.uniquindio.poo.bibliotecajfx.controller.RealizarDevolucionController;
import co.edu.uniquindio.poo.bibliotecajfx.model.FormatoLibro;
import co.edu.uniquindio.poo.bibliotecajfx.model.LibroDigital;
import co.edu.uniquindio.poo.bibliotecajfx.model.Prestamo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class RealizarDevolucionViewController {
    RealizarDevolucionController realizarDevolucionController;
    ObservableList<Prestamo> listPrestamos = FXCollections.observableArrayList();
    Prestamo selectedPrestamo;
    App app;
    @FXML
    private TableView<Prestamo> tablaPrestamos;

    @FXML
    private TableColumn<Prestamo, LocalDate> columnaFechaPrestamo;

    @FXML
    private TableColumn<Prestamo, LocalDate> columnaFechaLimite;

    @FXML
    private TableColumn<Prestamo, String> columnaLibro;

    @FXML
    private TableColumn<Prestamo, String> columnaUsuario;


    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnRealizarDevolucion;

    @FXML
    void onRegresar(){
        app.openCrudBibliotecario();
    }

    @FXML
    void onRealizarDevolucion(){
        Prestamo prestamoSeleccionado = tablaPrestamos.getSelectionModel().getSelectedItem();
        if (prestamoSeleccionado != null) {
            listPrestamos.remove(prestamoSeleccionado);
            realizarDevolucionController.realizarDevolucion(prestamoSeleccionado.getUsuario().getIdentificacion(), prestamoSeleccionado.getLibro().getTitulo());
        } else {
            mostrarAlerta("Advertencia", "Debe seleccionar un libro para eliminar.");
        }
    }
    @FXML
    void initView() {


        initDataBinding();


        obtenerHistorialPrestamosEstudiante();


        tablaPrestamos.getItems().clear();


        tablaPrestamos.setItems(listPrestamos);

    }

    public void initDataBinding() {
        columnaFechaPrestamo.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getFechaPrestamo()));
        columnaFechaLimite.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getFechaLimite()));
        columnaLibro.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getLibro().getTitulo()));
        columnaUsuario.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getUsuario().getIdentificacion()));
    }

    public void setApp(App app) {
        this.app = app;
       realizarDevolucionController = new RealizarDevolucionController(App.bibliotecario);
        initView();
    }
    @FXML
    private void obtenerHistorialPrestamosEstudiante() {
        listPrestamos.addAll(realizarDevolucionController.listPrestamos());
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
