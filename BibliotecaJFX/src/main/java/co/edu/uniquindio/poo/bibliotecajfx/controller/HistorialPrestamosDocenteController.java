package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;

import co.edu.uniquindio.poo.bibliotecajfx.model.Docente;
import co.edu.uniquindio.poo.bibliotecajfx.model.Prestamo;

import java.util.List;

public class HistorialPrestamosDocenteController {
    Biblioteca biblioteca;
    Docente docente;
    public HistorialPrestamosDocenteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.docente = (Docente) biblioteca.getUsuarioLogueado();
    }


    public List<Prestamo> mostrarHistorialPrestamosDocente(){
        return docente.getListHistorialPrestamosDocentes();
    }
}
