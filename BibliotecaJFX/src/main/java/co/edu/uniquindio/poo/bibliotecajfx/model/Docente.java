package co.edu.uniquindio.poo.bibliotecajfx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un docente, que hereda de la clase Usuario y puede gestionar préstamos de libros.
 * Implementa la interfaz IPrestamosUsuarios para manejar las operaciones relacionadas con préstamos.
 */
public class Docente extends Usuario implements IPrestamosUsuarios {
    private int maxDiasPrestamo;
    private int cantidadLibrosMax;
    private List<Prestamo> listPrestamosDocentes;
    private List<Prestamo> listHistorialPrestamosDocentes;

    /**
     * Constructor de la clase Docente.
     *
     * @param nombre         el nombre del docente.
     * @param identificacion la identificación del docente.
     * @param edad           la edad del docente.
     * @param correo         el correo electrónico del docente.
     * @param telefono       el número de teléfono del docente.
     * @param contrasenia    la contraseña del docente.
     */
    public Docente(String nombre, String identificacion, int edad, String correo, String telefono, String contrasenia) {
        super(nombre, identificacion, edad, correo, telefono, contrasenia);
        this.maxDiasPrestamo = 30;
        this.cantidadLibrosMax = 3;
        this.listPrestamosDocentes = new ArrayList<>();
        this.listHistorialPrestamosDocentes = new ArrayList<>();
    }

    /**
     * Obtiene el número máximo de días de préstamo permitido para el docente.
     *
     * @return el número máximo de días de préstamo.
     */
    public int getMaxDiasPrestamo() {
        return maxDiasPrestamo;
    }

    /**
     * Actualiza el número máximo de días de préstamo permitido para el docente.
     *
     * @param maxDiasPrestamo el nuevo número máximo de días de préstamo.
     */
    public void setMaxDiasPrestamo(int maxDiasPrestamo) {
        this.maxDiasPrestamo = maxDiasPrestamo;
    }

    /**
     * Obtiene la cantidad máxima de libros que el docente puede prestar al mismo tiempo.
     *
     * @return la cantidad máxima de libros permitidos.
     */
    public int getCantidadLibrosMax() {
        return cantidadLibrosMax;
    }

    /**
     * Actualiza la cantidad máxima de libros que el docente puede prestar al mismo tiempo.
     *
     * @param cantidadLibrosMax la nueva cantidad máxima de libros permitidos.
     */
    public void setCantidadLibrosMax(int cantidadLibrosMax) {
        this.cantidadLibrosMax = cantidadLibrosMax;
    }

    /**
     * Obtiene la lista de préstamos actuales del docente.
     *
     * @return una lista de préstamos activos.
     */
    public List<Prestamo> getListPrestamosDocentes() {
        return listPrestamosDocentes;
    }

    /**
     * Actualiza la lista de préstamos activos del docente.
     *
     * @param listPrestamosDocentes la nueva lista de préstamos que reemplazará la lista actual.
     */
    public void setListPrestamosDocentes(List<Prestamo> listPrestamosDocentes) {
        this.listPrestamosDocentes = listPrestamosDocentes;
    }

    /**
     * Actualiza la lista con el historial completo de préstamos realizados por el docente.
     *
     * @param listHistorialPrestamosDocentes la lista de préstamos que representa el historial de préstamos del docente
     */
    public void setListHistorialPrestamosDocentes(List<Prestamo> listHistorialPrestamosDocentes) {
        this.listHistorialPrestamosDocentes = listHistorialPrestamosDocentes;
    }

    /**
     * Obtiene el historial completo de préstamos realizados por el docente.
     *
     * @return una lista con el historial de todos los préstamos.
     */
    public List<Prestamo> getListHistorialPrestamosDocentes() {
        return listHistorialPrestamosDocentes;
    }

    /**
     * Determina si el docente puede realizar un nuevo préstamo.
     *
     * @return true si puede prestar, false de lo contrario.
     */
    @Override
    public boolean puedePrestar() {
        if (cantidadLibrosPrestados() < cantidadLibrosMax) {
            return true;
        }
        return false;
    }

    /**
     * Calcula y devuelve la cantidad de libros que el docente tiene actualmente en préstamo.
     *
     * @return la cantidad de libros prestados.
     */
    @Override
    public int cantidadLibrosPrestados() {
        int contador = 0;
        for (int i = 0; i < listPrestamosDocentes.size(); i++) {
            if (listPrestamosDocentes.get(i).estaPrestado()) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Agrega un nuevo préstamo a la lista de préstamos activos y al historial del docente.
     *
     * @param prestamo el préstamo que se desea agregar.
     */
    public void agregarPrestamo(Prestamo prestamo) {
        listPrestamosDocentes.add(prestamo);
        listHistorialPrestamosDocentes.add(prestamo);
    }

    /**
     * Marca un préstamo como devuelto, eliminándolo de la lista de préstamos activos del docente.
     *
     * @param prestamo el préstamo que se ha devuelto.
     */
    @Override
    public void libroDevuelto(Prestamo prestamo) {
        listPrestamosDocentes.remove(prestamo);
    }
}
