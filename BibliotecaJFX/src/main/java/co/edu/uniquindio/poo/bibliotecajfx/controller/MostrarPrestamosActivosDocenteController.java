package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;
import co.edu.uniquindio.poo.bibliotecajfx.model.Docente;
import co.edu.uniquindio.poo.bibliotecajfx.model.Prestamo;

import java.util.List;

public class MostrarPrestamosActivosDocenteController {
    Biblioteca biblioteca;
    Docente docente;
    public MostrarPrestamosActivosDocenteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.docente = (Docente) biblioteca.getUsuarioLogueado();
    }


    public List<Prestamo> mostrarPrestamosActivosDocente(){
        return docente.getListPrestamosDocentes();
    }
}
