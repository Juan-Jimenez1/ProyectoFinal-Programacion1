package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.HistorialPrestamosEstudianteController;
import co.edu.uniquindio.poo.bibliotecajfx.model.LibroFisico;
import co.edu.uniquindio.poo.bibliotecajfx.model.Prestamo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class HistorialPrestamosEstudianteViewController {
    HistorialPrestamosEstudianteController historialPrestamosEstudianteController;
    ObservableList<Prestamo>listHistorialPrestamosEstudiante = FXCollections.observableArrayList();
    App app;
    @FXML
    private TableView<Prestamo> tablaHistorialPrestamosEstudiante;

    @FXML
    private TableColumn<Prestamo, LocalDate> columnaFechaPrestamo;

    @FXML
    private TableColumn<Prestamo, LocalDate> columnaFechaLimite;

    @FXML
    private TableColumn<Prestamo, LocalDate> columnaFechaDevolucion;

    @FXML
    private TableColumn<Prestamo, String> columnaLibro;

    @FXML
    private TableColumn<Prestamo, String> columnaUsuario;


    @FXML
    private Button btnRegresar;

    @FXML
    void onRegresar(){
        app.openCrudEstudiante();
    }
    @FXML
    void initView() {


        initDataBinding();


        obtenerHistorialPrestamosEstudiante();


        tablaHistorialPrestamosEstudiante.getItems().clear();


        tablaHistorialPrestamosEstudiante.setItems(listHistorialPrestamosEstudiante);

    }

    public void initDataBinding() {
        columnaFechaPrestamo.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getFechaPrestamo()));
        columnaFechaLimite.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getFechaLimite()));
        columnaFechaDevolucion.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getFechaDevolucion()));
        columnaLibro.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getLibro().getTitulo()));
        columnaUsuario.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getUsuario().getIdentificacion()));
    }

    public void setApp(App app) {
        this.app = app;
        historialPrestamosEstudianteController = new HistorialPrestamosEstudianteController(App.biblioteca);
        initView();
    }
    @FXML
    private void obtenerHistorialPrestamosEstudiante() {
        listHistorialPrestamosEstudiante.addAll(historialPrestamosEstudianteController.mostrarHistorialPrestamos());
    }

}
