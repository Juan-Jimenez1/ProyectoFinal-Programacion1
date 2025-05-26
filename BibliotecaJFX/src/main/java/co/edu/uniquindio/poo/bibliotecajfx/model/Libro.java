package co.edu.uniquindio.poo.bibliotecajfx.model;

/**
 * Representa un libro con información básica como título, autor, género, año de publicación 
 * y estado de disponibilidad. También mantiene un registro de la cantidad de veces que ha sido prestado.
 */
public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private EstadoLibro estado;
    private int cantidadVecesPrestado;

    /**
     * Constructor de la clase Libro. Inicializa un objeto Libro con los valores proporcionados
     * para el título, autor, género y año de publicación, estableciendo su estado inicial
     * como disponible y la cantidad de veces prestado en cero.
     *
     * @param titulo el título del libro.
     * @param autor el autor del libro.
     * @param genero el género del libro.
     * @param anioPublicacion el año en que el libro fue publicado.
     */
    public Libro(String titulo, String autor, String genero, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.estado = EstadoLibro.DISPONIBLE;
        this.cantidadVecesPrestado = 0;
        assert titulo != null;
        assert autor != null;
        assert genero != null;
    }


    /**
     * Obtiene el título del libro.
     *
     * @return el título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Actualiza el título del libro.
     *
     * @param titulo el nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return el autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Actualiza el autor del libro.
     *
     * @param autor el nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene el género del libro.
     *
     * @return el género del libro.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Actualiza el género del libro.
     *
     * @param genero el nuevo género del libro.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }


    /**
     * Obtiene el año de publicación del libro.
     *
     * @return el año de publicación del libro.
     */
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    /**
     * Actualiza el año de publicación del libro.
     *
     * @param anioPublicacion el nuevo año de publicación del libro.
     */
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * Obtiene el estado actual del libro.
     *
     * @return el estado del libro.
     */
    public EstadoLibro getEstado() {
        return estado;
    }


    /**
     * Actualiza el estado del libro.
     *
     * @param estado el nuevo estado del libro.
     */
    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    /**
     * Verifica si el libro está disponible para ser prestado.
     *
     * @return true si el libro está disponible, de lo contrario false.
     */
    public boolean estaDisponible() {
        if (estado == EstadoLibro.DISPONIBLE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtiene la cantidad de veces que el libro ha sido prestado.
     *
     * @return la cantidad de veces que el libro ha sido prestado.
     */
    public int getCantidadVecesPrestado() {
        return cantidadVecesPrestado;
    }

    /**
     * Actualiza la cantidad de veces que el libro ha sido prestado.
     *
     * @param cantidadVecesPrestado el nuevo número de veces que el libro ha sido prestado.
     */
    public void setCantidadVecesPrestado(int cantidadVecesPrestado) {
        this.cantidadVecesPrestado = cantidadVecesPrestado;
    }

    /**
     * Representa la información del libro como una cadena de texto.
     *
     * @return una representación en forma de cadena del libro.
     */
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                ", estado=" + estado +
                '}';
    }
}


