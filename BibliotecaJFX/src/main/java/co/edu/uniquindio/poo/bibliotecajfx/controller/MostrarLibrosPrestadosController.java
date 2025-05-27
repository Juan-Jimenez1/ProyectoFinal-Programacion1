package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;

import java.util.List;

public class MostrarLibrosPrestadosController {
    Bibliotecario bibliotecario;

    public MostrarLibrosPrestadosController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public List<Libro>librosPrestados(){
        return bibliotecario.librosPrestados();
    }
}
