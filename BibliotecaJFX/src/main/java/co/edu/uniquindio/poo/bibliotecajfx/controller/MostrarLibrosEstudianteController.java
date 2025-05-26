package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;

import java.util.List;

public class MostrarLibrosEstudianteController {
    Biblioteca biblioteca;

    public MostrarLibrosEstudianteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Libro> mostrarLibrosEstudiante(){
        return biblioteca.getListLibros();
    }
}
