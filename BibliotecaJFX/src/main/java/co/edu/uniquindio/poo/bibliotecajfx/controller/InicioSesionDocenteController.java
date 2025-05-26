package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;

public class InicioSesionDocenteController {
    Biblioteca biblioteca;
    public InicioSesionDocenteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public boolean iniciarSesionDocente(String identificacion, String contrasenia){
        return biblioteca.iniciarSesionUsuario(identificacion,contrasenia);
    }
}
