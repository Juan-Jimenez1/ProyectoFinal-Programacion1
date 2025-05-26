package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Docente;
import co.edu.uniquindio.poo.bibliotecajfx.model.Estudiante;

import java.util.List;

public class GestionDocenteController {
    Bibliotecario bibliotecario;
    public GestionDocenteController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void crearDocente(Docente docente) {
        bibliotecario.agregarDocente(docente);
    }

    public List<Docente> obtenerListaDocentes() {
        return bibliotecario.getBiblioteca().getListDocentes();
    }

    public void eliminarDocente(String identificacion) {
        bibliotecario.eliminarDocente(identificacion);
    }

    public void actualizarDocente(String identificacion, Docente docente) {
        bibliotecario.actualizarDocente(identificacion, docente);
    }
}
