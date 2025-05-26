package co.edu.uniquindio.poo.bibliotecajfx.model;

/**
 * La interfaz IGestionPrestamo define los comportamientos básicos para la gestión de préstamos y devoluciones
 * de objetos, proporcionando una estructura general que debe ser implementada por las clases que representen
 * elementos prestables.
 */
public interface IGestionPrestamo {
    public void prestar();
    public void devolver();
}
