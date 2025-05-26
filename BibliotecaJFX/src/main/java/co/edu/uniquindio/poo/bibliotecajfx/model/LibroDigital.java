package co.edu.uniquindio.poo.bibliotecajfx.model;

/**
 * Representa un libro físico que hereda de la clase Libro e implementa la interfaz IGestionPrestamo.
 * Contiene información adicional como el link de descarga y el formato del libro.
 */
public class LibroDigital extends Libro implements IGestionPrestamo {
    private String linkDescarga;
    private FormatoLibro formato;

    /**
     * Constructor de la clase LibroDigital.
     *
     * @param titulo          El título del libro digital.
     * @param autor           El autor del libro digital.
     * @param genero          El género del libro digital.
     * @param anioPublicacion El año de publicación del libro digital.
     * @param estado          El estado del libro digital.
     * @param linkDescarga    El enlace de descarga del libro digital.
     * @param formato         El formato del libro digital (PDF, EPUB, MOBI, etc.).
     */
    public LibroDigital(String titulo, String autor, String genero, int anioPublicacion, EstadoLibro estado, String linkDescarga, FormatoLibro formato) {
        super(titulo, autor, genero, anioPublicacion);
        this.linkDescarga = linkDescarga;
        this.formato = formato;
    }

    /**
     * Obtiene el enlace de descarga del libro digital.
     *
     * @return El enlace de descarga del libro digital.
     */
    public String getLinkDescarga() {
        return linkDescarga;
    }

    /**
     * Actualiza el enlace de descarga del libro digital.
     *
     * @param linkDescarga El nuevo enlace de descarga del libro digital.
     */
    public void setLinkDescarga(String linkDescarga) {
        this.linkDescarga = linkDescarga;
    }

    /**
     * Obtiene el formato del libro digital.
     *
     * @return El formato del libro digital.
     */
    public FormatoLibro getFormato() {
        return formato;
    }

    /**
     * Actualiza el formato del libro digital.
     *
     * @param formato El nuevo formato del libro digital.
     */
    public void setFormato(FormatoLibro formato) {
        this.formato = formato;
    }

    /**
     * Realiza el préstamo del libro digital, cambiando su estado a PRESTADO y aumentando la cantidad
     * de veces que ha sido prestado.
     */
    @Override
    public void prestar() {
        if (getEstado() == EstadoLibro.DISPONIBLE) {
            setEstado(EstadoLibro.PRESTADO);
            setCantidadVecesPrestado(getCantidadVecesPrestado() + 1);
        }
    }

    /**
     * Realiza la devolución del libro digital, cambiando su estado a DISPONIBLE si estaba prestado.
     */
    @Override
    public void devolver() {
        if (getEstado() == EstadoLibro.PRESTADO) {
            setEstado(EstadoLibro.DISPONIBLE);
        }
    }

    /**
     * Representa el libro digital como una cadena de texto.
     *
     * @return Una representación en forma de cadena del libro digital.
     */
    @Override
    public String toString() {
        return "LibroDigital{" +
                "linkDescarga='" + linkDescarga + '\'' +
                ", formato=" + formato +
                '}';
    }
}


