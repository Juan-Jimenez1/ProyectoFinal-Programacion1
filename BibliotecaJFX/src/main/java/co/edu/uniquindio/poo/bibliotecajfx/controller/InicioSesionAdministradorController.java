package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;

public class InicioSesionAdministradorController {
    Biblioteca biblioteca;

    public InicioSesionAdministradorController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean IniciarSesionAdministrador(String credencial, String contrasenia){
        return biblioteca.iniciarSesionEmpleado(credencial, contrasenia);
    }
}
