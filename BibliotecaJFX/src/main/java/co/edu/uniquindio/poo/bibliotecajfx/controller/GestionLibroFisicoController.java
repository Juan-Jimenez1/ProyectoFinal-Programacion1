package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.LibroFisico;

import java.util.List;

public class GestionLibroFisicoController {
    Bibliotecario bibliotecario;

    public GestionLibroFisicoController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void crearLibroFisico(LibroFisico libroFisico) {
        bibliotecario.agregarLibroFisico(libroFisico);
    }

    public List<LibroFisico> obtenerListaLibrosFisicos() {
        return bibliotecario.getBiblioteca().getListLibrosFisicos();
    }

    public void eliminarLibroFisico(String titulo) {
     bibliotecario.eliminarLibroFisico(titulo);
    }

    public void actualizarLibroFisico(String titulo, LibroFisico libroFisico) {
        bibliotecario.actualizarLibroFisico(titulo,libroFisico);

    }
}


