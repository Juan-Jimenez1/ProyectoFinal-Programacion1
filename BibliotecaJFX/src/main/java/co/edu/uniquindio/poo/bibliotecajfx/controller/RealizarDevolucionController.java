package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Prestamo;

import java.util.List;

public class RealizarDevolucionController {
    Bibliotecario bibliotecario;
    public RealizarDevolucionController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public void realizarDevolucion(String identificacion,String titulo){
        bibliotecario.realizarDevolucion(identificacion,titulo);
    }
    public List<Prestamo>listPrestamos(){
        return bibliotecario.getBiblioteca().getListPrestamos();
    }
}
