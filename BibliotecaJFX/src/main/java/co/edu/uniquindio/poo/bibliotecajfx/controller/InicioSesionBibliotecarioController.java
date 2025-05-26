package co.edu.uniquindio.poo.bibliotecajfx.controller;
import co.edu.uniquindio.poo.bibliotecajfx.model.Biblioteca;

public class InicioSesionBibliotecarioController {
    Biblioteca biblioteca;

    public InicioSesionBibliotecarioController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean iniciarSesionBibliotecario(String credencial,String contrasenia){
        return biblioteca.iniciarSesionEmpleado(credencial,contrasenia);
    }
}
