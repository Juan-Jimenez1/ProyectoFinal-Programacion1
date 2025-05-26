package co.edu.uniquindio.poo.bibliotecajfx.model;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un préstamo en una biblioteca.
 */
public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
    private List<Prestamo> listHistorialDePrestamos;
    private int valorDiaMora;

    /**
     * Constructor para inicializar un préstamo.
     *
     * @param fechaPrestamo Fecha en la que se realiza el préstamo.
     * @param fechaLimite   Fecha límite para devolver el libro.
     * @param libro         Libro prestado.
     * @param usuario       Usuario que realiza el préstamo.
     */
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaLimite, Libro libro, Usuario usuario) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.fechaDevolucion = null;
        this.devuelto = false;
        this.libro = libro;
        this.usuario = usuario;
        this.valorDiaMora = 15000;
        this.listHistorialDePrestamos = new ArrayList<>();
    }

    /**
     * Método para devolver un libro.
     * Calcula si el préstamo está vencido y realiza las acciones correspondientes.
     */
    public void devolverLibro() {
        fechaDevolucion = LocalDate.now();
        if (estaVencido()) {
            calcularValorPrestamo();
            JOptionPane.showMessageDialog(null, "El préstamo ha sido devuelto con un valor a pagar de: $" + calcularValorPrestamo());
        } else {
            JOptionPane.showMessageDialog(null, "Libro devuelto con éxito!");
        }
        if (libro instanceof LibroDigital libroDigital) {
            libroDigital.devolver();
            devuelto = true;
        }
        if (libro instanceof LibroFisico libroFisico) {
            libroFisico.devolver();
            devuelto = true;
        }
    }

    /**
     * Método para prestar un libro.
     * Actualiza el estado del libro dependiendo de su tipo.
     */
    public void prestarLibro() {
        if (libro instanceof LibroDigital libroDigital) {
            libroDigital.prestar();
        }
        if (libro instanceof LibroFisico libroFisico) {
            libroFisico.prestar();
        }
    }

    /**
     * Calcula el valor a pagar por un préstamo en caso de que esté vencido.
     *
     * @return El monto total a pagar si el préstamo tuvo días de mora. Si no hay mora, retorna 0.
     */
    public double calcularValorPrestamo() {
        if (fechaDevolucion != null && fechaDevolucion.isAfter(fechaLimite)) {
            long diasDeMora = java.time.temporal.ChronoUnit.DAYS.between(fechaLimite, fechaDevolucion);
            return diasDeMora * valorDiaMora;
        }
        return 0.0;
    }

    /**
     * Verifica si el préstamo está vencido.
     *
     * @return true si la fecha actual supera la fecha límite y el libro no ha sido devuelto; false en caso contrario.
     */
    public boolean estaVencido() {
        boolean vencido = !devuelto && LocalDate.now().isAfter(fechaLimite);
        return vencido;
    }

    /**
     * Obtiene el valor por día de mora.
     *
     * @return El valor establecido para la mora diaria.
     */
    public double getValorDiaMora() {
        return valorDiaMora;
    }

    /**
     * Actualiza el valor por día de mora.
     *
     * @param valorDiaMora Nuevo valor por día de mora.
     */
    public void setValorDiaMora(int valorDiaMora) {
        this.valorDiaMora = valorDiaMora;
    }

    /**
     * Verifica si el libro está actualmente prestado.
     *
     * @return true si el libro no ha sido devuelto; false en caso contrario.
     */
    public boolean estaPrestado() {
        return !devuelto;
    }

    /**
     * Obtiene el libro asociado al préstamo.
     *
     * @return el libro prestado.
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Obtiene el usuario asociado al préstamo.
     *
     * @return el usuario que realizó el préstamo.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Obtiene la fecha en la que se realizó el préstamo.
     *
     * @return la fecha del préstamo como un objeto de tipo LocalDate.
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Obtiene la fecha límite para devolver el préstamo.
     *
     * @return la fecha límite de devolución del préstamo.
     */
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    /**
     * Obtiene la fecha en la que se realizó la devolución del libro en préstamo.
     *
     * @return la fecha de devolución del libro como un objeto LocalDate.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Obtiene la lista del historial de préstamos registrados.
     *
     * @return una lista de objetos de tipo {@code Prestamo} que representan el historial de préstamos.
     */
    public List<Prestamo> getListHistorialDePrestamos() {
        return listHistorialDePrestamos;
    }

    /**
     * Obtiene si el libro ha sido devuelto.
     *
     * @return true si el libro ha sido devuelto; false en caso contrario.
     */
    public boolean getDevuelto() {
        return devuelto;
    }

    /**
     * Actualiza la fecha en la que se devolvió el libro.
     *
     * @param fechaDevolucion La fecha de devolución del libro.
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Actualiza el estado del préstamo para indicar si el libro ha sido devuelto.
     *
     * @param devuelto true si el libro ha sido devuelto; false en caso contrario.
     */
    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    /**
     * Actualiza la fecha en la que se realiza el préstamo.
     *
     * @param fechaPrestamo la fecha del préstamo a establecer.
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Actualiza la fecha límite para la devolución del préstamo.
     *
     * @param fechaLimite La nueva fecha límite para devolver el libro.
     */
    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * Actualiza la lista del historial de préstamos.
     *
     * @param listHistorialDePrestamos Lista de objetos de tipo Prestamo que representa el historial de préstamos.
     */
    public void setListHistorialDePrestamos(List<Prestamo> listHistorialDePrestamos) {
        this.listHistorialDePrestamos = listHistorialDePrestamos;
    }

    /**
     * Actualiza el libro asociado al préstamo.
     *
     * @param libro Objeto de la clase Libro que representa el libro a ser asociado con el préstamo.
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Actualiza el usuario asociado con el préstamo.
     *
     * @param usuario el usuario que se asociará con el préstamo.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna un String que representa el préstamo.
     *
     * @return Información completa del préstamo en formato String.
     */
    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaLimite=" + fechaLimite +
                ", fechaDevolucion=" + fechaDevolucion +
                ", devuelto=" + devuelto +
                '}';
    }
}
