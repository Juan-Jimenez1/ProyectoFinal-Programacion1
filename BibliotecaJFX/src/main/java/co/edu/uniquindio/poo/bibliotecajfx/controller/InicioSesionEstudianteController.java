package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;

public class InicioSesionEstudianteController {
    Biblioteca biblioteca;
    public InicioSesionEstudianteController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public boolean iniciarSesionEstudiante(String identificacion, String contrasenia){
        return biblioteca.iniciarSesionUsuario(identificacion,contrasenia);
    }
}
