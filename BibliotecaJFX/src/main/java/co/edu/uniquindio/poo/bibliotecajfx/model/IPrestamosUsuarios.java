package co.edu.uniquindio.poo.bibliotecajfx.model;

/**
 * Interface que define los métodos necesarios para gestionar préstamos de libros para los usuarios.
 * Esta interfaz está destinada a ser implementada por clases que representan usuarios que pueden pedir y devolver libros.
 */
public interface IPrestamosUsuarios {
    boolean puedePrestar();

    int cantidadLibrosPrestados();

    void libroDevuelto(Prestamo prestamo);
}
