package co.edu.uniquindio.poo.bibliotecajfx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un usuario con información básica como nombre, identificación, edad,
 * correo electrónico, teléfono y contraseña. Actúa como una clase base para
 * especializaciones de usuario, como docentes u otros tipos de usuarios.
 */
public class Usuario {
    private String nombre;
    private String identificacion;
    private int edad;
    private String correo;
    private String telefono;
    private String contrasenia;

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombre         el nombre del usuario.
     * @param identificacion la identificación del usuario.
     * @param edad           la edad del usuario.
     * @param correo         el correo electrónico del usuario.
     * @param telefono       el número de teléfono del usuario.
     * @param contrasenia    la contraseña del usuario.
     */
    public Usuario(String nombre, String identificacion, int edad, String correo, String telefono, String contrasenia) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        assert nombre != null;
        assert identificacion != null;
        assert correo != null;
        assert telefono != null;
        assert contrasenia != null;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del usuario.
     *
     * @param nombre el nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la identificación del usuario.
     *
     * @return la identificación del usuario.
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Actualiza la identificación del usuario.
     *
     * @param identificacion la nueva identificación del usuario.
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene la edad del usuario.
     *
     * @return la edad del usuario.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Actualiza la edad del usuario.
     *
     * @param edad la nueva edad del usuario.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return el correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Actualiza el correo electrónico del usuario.
     *
     * @param correo el nuevo correo del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return la contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Actualiza la contraseña del usuario.
     *
     * @param contrasenia la nueva contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     *
     * @return el número de teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Actualiza el número de teléfono del usuario.
     *
     * @param telefono el nuevo número de teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo toString que muestra la información de un objeto Usuario como una cadena.
     *
     * @return una cadena que contiene la información del usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
