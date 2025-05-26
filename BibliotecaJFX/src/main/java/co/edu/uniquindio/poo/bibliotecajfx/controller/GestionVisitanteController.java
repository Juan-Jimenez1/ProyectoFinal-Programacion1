package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Visitante;

import java.util.List;

public class GestionVisitanteController {
    Bibliotecario bibliotecario;
    public GestionVisitanteController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void crearVisitante(Visitante visitante) {
        bibliotecario.agregarVisitante(visitante);
    }

    public List<Visitante> obtenerListaVisitantes() {
        return bibliotecario.getBiblioteca().getListVisitantes();
    }

    public void eliminarVisitante(String identificacion) {
        bibliotecario.eliminarVisitante(identificacion);
    }

    public void actualizarVisitante(String identificacion, Visitante visitante) {
        bibliotecario.actualizarVisitante(identificacion, visitante);
    }
}
