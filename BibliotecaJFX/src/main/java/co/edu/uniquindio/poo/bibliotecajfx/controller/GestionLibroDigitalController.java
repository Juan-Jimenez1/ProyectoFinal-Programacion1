package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.LibroDigital;

import java.util.List;

public class GestionLibroDigitalController {
    Bibliotecario bibliotecario;

    public GestionLibroDigitalController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void crearLibroDigital(LibroDigital libroDigital) {
        bibliotecario.agregarLibroDigital(libroDigital);
    }

    public List<LibroDigital> obtenerListaLibrosDigitales() {
        return bibliotecario.getBiblioteca().getListLibrosDigitales();
    }

    public void eliminarLibroDigital(String titulo) {
        bibliotecario.eliminarLibroDigital(titulo);
    }

    public void actualizarLibroDigital(String titulo, LibroDigital libroDigital) {
        bibliotecario.actualizarLibroDigital(titulo, libroDigital);
    }
}


