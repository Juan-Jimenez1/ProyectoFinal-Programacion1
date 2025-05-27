package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.model.Usuario;

import java.util.List;

public class UsuariosDeudoresController {
    Bibliotecario bibliotecario;
    public UsuariosDeudoresController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    public List<Usuario>usuariosDeudores(){
        return bibliotecario.UsuariosDeudores();
    }
}
