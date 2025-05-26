package co.edu.uniquindio.poo.bibliotecajfx.model;

/**
 * Representa un libro de referencia que extiende la clase base Libro.
 * Los libros de referencia tienen como característica particular
 * que su estado siempre se establece como REFERENCIA y no están disponibles para préstamo.
 */
public class LibroReferencia extends Libro {
    public LibroReferencia(String titulo, String autor, String genero,EstadoLibro estadoLibro,int anioPublicacion) {
        super(titulo, autor, genero, anioPublicacion);
        setEstado(EstadoLibro.REFERENCIA);
    }

}
