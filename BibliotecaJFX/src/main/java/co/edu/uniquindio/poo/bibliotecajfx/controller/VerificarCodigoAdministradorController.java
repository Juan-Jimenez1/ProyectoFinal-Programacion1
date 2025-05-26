package co.edu.uniquindio.poo.bibliotecajfx.controller;

import co.edu.uniquindio.poo.bibliotecajfx.model.Administrador;

public class VerificarCodigoAdministradorController {
    Administrador administrador;
    public VerificarCodigoAdministradorController(Administrador administrador) {
        this.administrador = administrador;
    }

    public boolean verificarCodigo(int codigo){
        return administrador.verificarCodigoVerificacion(codigo);
    }
    public boolean enviarCodigoVerificacion(){
        return administrador.enviarCodigoVerificacion();
    }
}
