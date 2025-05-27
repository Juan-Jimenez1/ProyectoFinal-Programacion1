package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Libro;
import co.edu.uniquindio.poo.bibliotecajfx.model.Prestamo;
import co.edu.uniquindio.poo.bibliotecajfx.model.Usuario;

import java.util.List;

public class PrestamoController {
    Bibliotecario bibliotecario;
    public PrestamoController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public void crearPrestamo(Prestamo prestamo){
        bibliotecario.realizarPrestamo(prestamo.getUsuario().getIdentificacion(),prestamo.getLibro().getTitulo(),prestamo.getFechaPrestamo(),prestamo.getFechaLimite());
    }
    public Usuario buscarUsuario(String identificacion){
        return bibliotecario.getBiblioteca().buscarUsuario(identificacion);
    }
    public List<Libro>listLibros(){
        return bibliotecario.getBiblioteca().getListLibros();
    }

}
