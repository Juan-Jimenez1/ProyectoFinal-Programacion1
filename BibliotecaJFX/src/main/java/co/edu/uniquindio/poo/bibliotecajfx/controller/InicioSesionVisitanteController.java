package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;

public class InicioSesionVisitanteController {
    Biblioteca biblioteca;
    public InicioSesionVisitanteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public boolean iniciarSesionVisitante(String identificacion, String contrasenia){
        return biblioteca.iniciarSesionUsuario(identificacion,contrasenia);
    }
}
