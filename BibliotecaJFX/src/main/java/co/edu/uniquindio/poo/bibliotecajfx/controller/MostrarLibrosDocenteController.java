package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;

import java.util.List;

public class MostrarLibrosDocenteController {
    Biblioteca biblioteca;
    public MostrarLibrosDocenteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Libro> mostrarLibrosDocente(){
        return biblioteca.getListLibros();
    }
}
