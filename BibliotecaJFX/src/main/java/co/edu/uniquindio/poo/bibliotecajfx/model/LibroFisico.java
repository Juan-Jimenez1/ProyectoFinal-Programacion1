package co.edu.uniquindio.poo.bibliotecajfx.model;

/**
 * Representa un libro físico que hereda de la clase Libro e implementa la interfaz IGestionPrestamo.
 * Contiene información adicional como el número de páginas, la editorial y la ubicación en la biblioteca.
 */
public class LibroFisico extends Libro implements IGestionPrestamo {
    private int numeroPaginas;
    private String editorial;
    private String ubicacionBiblioteca;

    /**
     * Constructor de la clase LibroFisico.
     *
     * @param titulo              el título del libro.
     * @param autor               el autor del libro.
     * @param genero              el género del libro.
     * @param estadoLibro         el estado inicial del libro.
     * @param anioPublicacion     el año de publicación del libro.
     * @param numeroPaginas       el número de páginas del libro.
     * @param editorial           la editorial del libro.
     * @param ubicacionBiblioteca la ubicación del libro en la biblioteca.
     */
    public LibroFisico(String titulo, String autor, String genero, EstadoLibro estadoLibro, int anioPublicacion, int numeroPaginas, String editorial, String ubicacionBiblioteca) {
        super(titulo, autor, genero, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.ubicacionBiblioteca = ubicacionBiblioteca;
    }

    /**
     * Obtiene el número de páginas del libro.
     *
     * @return el número de páginas del libro.
     */
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    /**
     * Actualiza el número de páginas del libro.
     *
     * @param numeroPaginas el nuevo número de páginas del libro.
     */
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    /**
     * Obtiene la editorial del libro.
     *
     * @return la editorial del libro.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Actualiza la editorial del libro.
     *
     * @param editorial la nueva editorial del libro.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Actualiza la ubicación del libro en la biblioteca.
     *
     * @return la ubicación del libro en la biblioteca.
     */
    public String getUbicacionBiblioteca() {
        return ubicacionBiblioteca;
    }

    /**
     * Actualiza la ubicación del libro en la biblioteca.
     *
     * @param ubicacionBiblioteca la nueva ubicación del libro en la biblioteca.
     */
    public void setUbicacionBiblioteca(String ubicacionBiblioteca) {
        this.ubicacionBiblioteca = ubicacionBiblioteca;
    }

    /**
     * Realiza el préstamo del libro Físico, cambiando su estado a PRESTADO y aumentando la cantidad
     *de veces que ha sido prestado.
     */
    @Override
    public void prestar() {
        if (getEstado() == EstadoLibro.DISPONIBLE) {
            setEstado(EstadoLibro.PRESTADO);
            setCantidadVecesPrestado(getCantidadVecesPrestado() + 1);
        }
    }

    /**
     * Cambia el estado del libro a DISPONIBLE si se devuelve el libro.
     */
    @Override
    public void devolver() {
        if (getEstado() == EstadoLibro.PRESTADO) {
            setEstado(EstadoLibro.DISPONIBLE);
        }
    }

    /**
     * Representa la información del libro físico como una cadena de texto.
     *
     * @return una representación en forma de cadena del libro físico.
     */
    @Override
    public String toString() {
        return "LibroFisico{" +
                "numeroPaginas=" + numeroPaginas +
                ", editorial='" + editorial + '\'' +
                ", ubicacionBiblioteca='" + ubicacionBiblioteca + '\'' +
                '}';
    }
}


