package co.edu.uniquindio.poo.bibliotecajfx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un estudiante que puede solicitar préstamos de libros,
 * extendiendo las capacidades de la clase Usuario e implementando la interfaz IPrestamosUsuarios.
 */
public class Estudiante extends Usuario implements IPrestamosUsuarios {
    private int maxDiasPrestamo;
    private int cantidadLibrosMax;
    private List<Prestamo> listPrestamosEstudiante;
    private List<Prestamo> listHistorialPrestamosEstudiante;

    /**
     * Constructor de la clase Estudiante.
     *
     * @param nombre         el nombre del estudiante.
     * @param identificacion la identificación del estudiante.
     * @param edad           la edad del estudiante.
     * @param correo         el correo electrónico del estudiante.
     * @param telefono       el número de teléfono del estudiante.
     * @param contrasenia    la contraseña del estudiante.
     */
    public Estudiante(String nombre, String identificacion, int edad, String correo, String telefono, String contrasenia) {
        super(nombre, identificacion, edad, correo, telefono, contrasenia);
        this.maxDiasPrestamo = 15;
        this.cantidadLibrosMax = 1;
        this.listPrestamosEstudiante = new ArrayList<>();
        this.listHistorialPrestamosEstudiante = new ArrayList<>();
    }

    /**
     * Obtiene la cantidad máxima de días de préstamo permitidos para el estudiante.
     *
     * @return los días máximos de préstamo.
     */
    public int getMaxDiasPrestamo() {
        return maxDiasPrestamo;
    }

    /**
     * Actualiza la cantidad máxima de días de préstamo permitidos para el estudiante.
     *
     * @param maxDiasPrestamo los nuevos días máximos de préstamo.
     */
    public void setMaxDiasPrestamo(int maxDiasPrestamo) {
        this.maxDiasPrestamo = maxDiasPrestamo;
    }

    /**
     * Obtiene la cantidad máxima de libros que el estudiante puede prestar.
     *
     * @return la cantidad máxima de libros.
     */
    public int getCantidadLibrosMax() {
        return cantidadLibrosMax;
    }

    /**
     * Actualiza la cantidad máxima de libros que el estudiante puede prestar.
     *
     * @param cantidadLibrosMax la nueva cantidad máxima de libros.
     */
    public void setCantidadLibrosMax(int cantidadLibrosMax) {
        this.cantidadLibrosMax = cantidadLibrosMax;
    }

    /**
     * Obtiene la lista de préstamos actuales del estudiante.
     *
     * @return la lista de préstamos actuales.
     */
    public List<Prestamo> getListPrestamosEstudiante() {
        return listPrestamosEstudiante;
    }

    /**
     * Actualiza la lista de préstamos actuales asociados al estudiante.
     *
     * @param listPrestamosEstudiante la lista de objetos Prestamo que representa los préstamos actuales del estudiante.
     */
    public void setListPrestamosEstudiante(List<Prestamo> listPrestamosEstudiante) {
        this.listPrestamosEstudiante = listPrestamosEstudiante;
    }

    /**
     * Actualiza el historial de préstamos realizados por el estudiante.
     *
     * @param listHistorialPrestamosEstudiante la nueva lista de historial de préstamos que se asignará al estudiante
     */
    public void setListHistorialPrestamosEstudiante(List<Prestamo> listHistorialPrestamosEstudiante) {
        this.listHistorialPrestamosEstudiante = listHistorialPrestamosEstudiante;
    }

    /**
     * Obtiene el historial de todos los préstamos realizados por el estudiante.
     *
     * @return la lista del historial de préstamos.
     */
    public List<Prestamo> getListHistorialPrestamosEstudiante() {
        return listHistorialPrestamosEstudiante;
    }

    /**
     * Proporciona una representación en forma de cadena del objeto Estudiante.
     *
     * @return una cadena que contiene información sobre el estudiante.
     */
    @Override
    public String toString() {
        return "Estudiante{" +
                "maxDiasPrestamo=" + maxDiasPrestamo +
                ", cantidadLibrosMax=" + cantidadLibrosMax +
                '}';
    }

    /**
     * Verifica si el estudiante puede realizar un nuevo préstamo.
     *
     * @return true si puede realizar un préstamo, false en caso contrario.
     */
    @Override
    public boolean puedePrestar() {
        return cantidadLibrosPrestados() < cantidadLibrosMax;
    }

    /**
     * Calcula la cantidad de libros actualmente prestados por el estudiante.
     *
     * @return el número de libros en préstamo.
     */
    @Override
    public int cantidadLibrosPrestados() {
        int contador = 0;
        for (int i = 0; i < listPrestamosEstudiante.size(); i++) {
            if (listPrestamosEstudiante.get(i).estaPrestado()) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Elimina un préstamo de la lista de préstamos actuales del estudiante.
     *
     * @param prestamo el préstamo que fue devuelto.
     */
    @Override
    public void libroDevuelto(Prestamo prestamo) {
        listPrestamosEstudiante.remove(prestamo);
    }

    /**
     * Agrega un nuevo préstamo tanto a la lista de préstamos actuales
     * como al historial de préstamos del estudiante.
     *
     * @param prestamo el préstamo a agregar.
     */
    public void agregarPrestamo(Prestamo prestamo) {
        listPrestamosEstudiante.add(prestamo);
        listHistorialPrestamosEstudiante.add(prestamo);
    }
}
