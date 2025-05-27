package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;

import java.util.List;

public class LibroMasSolicitadoController {
    Bibliotecario bibliotecario;
    public LibroMasSolicitadoController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public List<Libro>libroMasSolicitado(){
        return bibliotecario.libroMasSolicitado();
    }
}
