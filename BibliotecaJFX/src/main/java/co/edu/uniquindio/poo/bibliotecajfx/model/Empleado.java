package co.edu.uniquindio.poo.bibliotecajfx.model;

/**
 * La clase Empleado representa a un empleado que hereda las propiedades de la clase Usuario.
 * Incluye una credencial única para identificar al empleado dentro del sistema.
 */
public class Empleado extends Usuario {
    private String credencial;

    /**
     * Constructor de la clase Empleado.
     *
     * @param nombre         Nombre del empleado.
     * @param identificacion Identificación única del empleado.
     * @param edad           Edad del empleado.
     * @param correo         Correo electrónico del empleado.
     * @param telefono       Teléfono de contacto del empleado.
     * @param contrasenia    Contraseña del empleado para acceder al sistema.
     * @param credencial     Credencial única asociada al empleado.
     */
    public Empleado(String nombre, String identificacion, int edad, String correo, String telefono, String contrasenia, String credencial) {
        super(nombre, identificacion, edad, correo, telefono, contrasenia);
        assert credencial != null : "La credencial no puede ser nula";
        this.credencial = credencial;
    }

    /**
     * Obtiene la credencial del empleado.
     *
     * @return Credencial del empleado.
     */
    public String getCredencial() {
        return credencial;
    }

    /**
     * Actualiza la credencial del empleado.
     *
     * @param credencial Nueva credencial del empleado.
     */
    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    /**
     * Retorna una representación en forma de cadena del objeto Empleado.
     *
     * @return Una cadena que describe al empleado y su credencial.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "credencial='" + credencial + '\'' +
                '}';
    }
}
