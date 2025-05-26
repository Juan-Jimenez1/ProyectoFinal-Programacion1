package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Administrador;
import co.edu.uniquindio.poo.bibliotecajfx.model.Usuario;

import java.util.List;

public class UsuarioConMasPrestamosController {
    Administrador administrador;
    public UsuarioConMasPrestamosController(Administrador administrador) {
        this.administrador = administrador;
    }
    public List<Usuario>mostrarUsuarioConMasPrestamos(){
        return administrador.usuarioConMasPrestamosRealizados();
    }
}

