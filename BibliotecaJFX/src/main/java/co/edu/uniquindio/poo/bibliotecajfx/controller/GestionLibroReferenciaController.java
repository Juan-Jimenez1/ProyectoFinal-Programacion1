package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;
import co.edu.uniquindio.poo.bibliotecajfx.model.LibroReferencia;

import java.util.List;

public class GestionLibroReferenciaController {
    Bibliotecario bibliotecario;

    public GestionLibroReferenciaController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void crearLibroReferencia(LibroReferencia libroReferencia) {
        bibliotecario.agregarLibroReferencia(libroReferencia);
    }

    public List<LibroReferencia> obtenerListaLibrosReferencia() {
        return bibliotecario.getBiblioteca().getListLibrosReferencia();
    }

    public void eliminarLibroReferencia(String titulo) {
     bibliotecario.eliminarLibroReferencia(titulo);
    }

    public void actualizarLibroReferencia(String titulo, LibroReferencia libroReferencia) {
      bibliotecario.actualizarLibroReferencia(titulo,libroReferencia);
    }
}


