package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.HistorialPrestamosDocenteController;
import co.edu.uniquindio.poo.bibliotecajfx.model.Prestamo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class HistorialPrestamosDocenteViewController {
    HistorialPrestamosDocenteController historialPrestamosDocenteController;
    ObservableList<Prestamo> listHistorialPrestamosDocente = FXCollections.observableArrayList();
    App app;
    @FXML
    private TableView<Prestamo> tablaHistorialPrestamosDocente;

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
    void onRegresar() {
        app.openCrudDocente();
    }

    @FXML
    void initView() {


        initDataBinding();


        obtenerHistorialPrestamosDocente();


        tablaHistorialPrestamosDocente.getItems().clear();


        tablaHistorialPrestamosDocente.setItems(listHistorialPrestamosDocente);

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
        historialPrestamosDocenteController = new HistorialPrestamosDocenteController(App.biblioteca);
        initView();
    }

    @FXML
    private void obtenerHistorialPrestamosDocente() {
        listHistorialPrestamosDocente.addAll(historialPrestamosDocenteController.mostrarHistorialPrestamosDocente());
    }

}
