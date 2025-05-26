package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Estudiante;

import java.util.List;

public class GestionEstudianteController {
    Bibliotecario bibliotecario;
    public GestionEstudianteController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public void crearEstudiante(Estudiante estudiante) {
        bibliotecario.agregarEstudiante(estudiante);
    }

    public List<Estudiante> obtenerListaEstudiantes() {
        return bibliotecario.getBiblioteca().getListEstudiantes();
    }

    public void eliminarEstudiante(String identificacion) {
        bibliotecario.eliminarEstudiante(identificacion);
    }

    public void actualizarEstudiante(String identificacion, Estudiante estudiante) {
        bibliotecario.actualizarEstudiante(identificacion,estudiante);

    }
}
