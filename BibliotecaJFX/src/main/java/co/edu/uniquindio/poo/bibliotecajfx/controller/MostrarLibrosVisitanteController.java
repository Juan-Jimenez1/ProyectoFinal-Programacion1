package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;

import java.util.List;

public class MostrarLibrosVisitanteController {
    Biblioteca biblioteca;
    public MostrarLibrosVisitanteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Libro> mostrarLibrosvisitante(){
        return biblioteca.getListLibros();

    }
}
