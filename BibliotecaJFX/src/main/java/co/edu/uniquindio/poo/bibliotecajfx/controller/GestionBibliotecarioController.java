package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Administrador;
import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;

import java.util.List;

public class GestionBibliotecarioController {
    Administrador administrador;
    public GestionBibliotecarioController(Administrador administrador) {
        this.administrador = administrador;
    }

    public void crearBibliotecario(Bibliotecario bibliotecario) {
        administrador.agregarBibliotecario(bibliotecario);
    }

    public List<Bibliotecario> obtenerListaBibliotecarios() {
        return administrador.getListBibliotecariosAdmin();
    }

    public void eliminarBibliotecario(String identificacion) {
        administrador.eliminarBibliotecario(identificacion);
    }

    public void actualizarBibliotecario(String identificacion, Bibliotecario bibliotecario) {
        administrador.actualizarBibliotecario(identificacion,bibliotecario);

    }
}
