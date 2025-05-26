package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Administrador;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;

import java.util.List;

public class LibrosSinPrestamosController {
    Administrador administrador;

    public LibrosSinPrestamosController(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Libro>librosSinPrestamos(){
        return administrador.librosSinPrestamos();
    }
}
