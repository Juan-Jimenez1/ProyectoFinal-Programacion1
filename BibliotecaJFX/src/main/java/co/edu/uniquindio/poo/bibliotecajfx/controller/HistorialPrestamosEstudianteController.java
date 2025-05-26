package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;
import co.edu.uniquindio.poo.bibliotecajfx.model.Estudiante;
import co.edu.uniquindio.poo.bibliotecajfx.model.Prestamo;

import java.util.List;

public class HistorialPrestamosEstudianteController {
    Biblioteca biblioteca;
    Estudiante estudiante;
    public HistorialPrestamosEstudianteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.estudiante = (Estudiante) biblioteca.getUsuarioLogueado();
    }


    public List<Prestamo> mostrarHistorialPrestamos(){
        return estudiante.getListHistorialPrestamosEstudiante();
    }
}
