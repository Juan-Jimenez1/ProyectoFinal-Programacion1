package co.edu.uniquindio.poo.bibliotecajfx.model;

/**
 * Representa un visitante que hereda de la clase Usuario.
 * Esta clase utiliza la información básica proporcionada por la clase Usuario,
 * incluyendo detalles como nombre, identificación, edad, correo, teléfono y contraseña.
 * Está diseñado para modelar usuarios temporales o no registrados permanentemente en el sistema.
 */
public class Visitante extends Usuario{
    public Visitante(String nombre, String identificacion, int edad, String correo, String telefono,String contrasenia) {
        super(nombre, identificacion, edad, correo, telefono,contrasenia);
    }

}
