package co.edu.uniquindio.poo.bibliotecajfx.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Administrador, quien extiende de Empleado.
 * El administrador tiene acceso y control sobre los Bibliotecarios y gestiona aspectos relacionados con la Biblioteca.
 */
public class Administrador extends Empleado {

    private List<Bibliotecario> listBibliotecariosAdmin;
    private int codigoGenerado;
    private Biblioteca biblioteca;

    /**
     * Constructor de la clase Administrador.
     *
     * @param nombre         Nombre del administrador.
     * @param identificacion Identificación del administrador.
     * @param edad           Edad del administrador.
     * @param correo         Correo del administrador.
     * @param telefono       Teléfono del administrador.
     * @param contrasenia    Contraseña del administrador.
     * @param credencial     Credencial del administrador.
     * @param biblioteca     Biblioteca asociada al administrador.
     */
    public Administrador(String nombre, String identificacion, int edad, String correo, String telefono, String contrasenia, String credencial, Biblioteca biblioteca) {
        super(nombre, identificacion, edad, correo, telefono, contrasenia, credencial);
        this.listBibliotecariosAdmin = new ArrayList<>();
        this.biblioteca = biblioteca;
    }

    /**
     * Obtiene el código generado para verificación.
     *
     * @return Código generado.
     */
    public int getCodigoGenerado() {
        return codigoGenerado;
    }

    /**
     * Actualiza el código generado para verificación.
     *
     * @param codigoGenerado Código generado.
     */
    public void setCodigoGenerado(int codigoGenerado) {
        this.codigoGenerado = codigoGenerado;
    }

    /**
     * Agrega un Bibliotecario al administrador y a la Biblioteca asociada.
     *
     * @param bibliotecario Instancia de Bibliotecario a agregar.
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (biblioteca.usuarioExiste(bibliotecario.getIdentificacion())) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            listBibliotecariosAdmin.add(bibliotecario);
            biblioteca.getListBibliotecarios().add(bibliotecario);
            biblioteca.actualizarListaEmpleados();
        }
    }

    /**
     * Elimina un Bibliotecario del administrador y de la Biblioteca asociada.
     *
     * @param identificacion Es la identificación del bibliotecario a eliminar.
     */
    public void eliminarBibliotecario(String identificacion) {
        for (int i = 0; i < listBibliotecariosAdmin.size(); i++) {
            if (listBibliotecariosAdmin.get(i).getIdentificacion().equals(identificacion)){
                listBibliotecariosAdmin.remove(i);
                biblioteca.getListBibliotecarios().remove(i);
                biblioteca.actualizarListaEmpleados();
                break;
            }
        }
    }

    /**
     * Actualiza la información de un Bibliotecario asociado al administrador.
     *
     * @param identificacion Identificación del Bibliotecario a actualizar.
     * @param bibliotecario  Nueva información del Bibliotecario.
     * @return true si la actualización fue exitosa o false en caso contrario.
     */
    public boolean actualizarBibliotecario(String identificacion, Bibliotecario bibliotecario) {
        for (int i = 0; i < listBibliotecariosAdmin.size(); i++) {
            if (listBibliotecariosAdmin.get(i).getIdentificacion().equals(identificacion)) {
                listBibliotecariosAdmin.set(i, bibliotecario);
                biblioteca.getListBibliotecarios().add(bibliotecario);
                biblioteca.actualizarListaEmpleados();
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista de Bibliotecarios del administrador.
     *
     * @return Lista de Bibliotecarios del administrador.
     */
    public List<Bibliotecario> getListBibliotecariosAdmin() {
        return listBibliotecariosAdmin;
    }

    /**
     * Genera un código de verificación aleatorio y lo notifica al usuario.
     *
     * @return true si el código fue generado correctamente.
     */
    public boolean enviarCodigoVerificacion() {
        codigoGenerado = (int) (Math.random() * 100) + 1;
        JOptionPane.showMessageDialog(null, ">>> Codigo de verificacion generado: " + codigoGenerado, "Información", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    /**
     * Verifica si el código ingresado coincide con el código generado.
     *
     * @param codigoVerificacion Código ingresado por el usuario.
     * @return true si la verificación es exitosa o false en caso contrario.
     */
    public boolean verificarCodigoVerificacion(int codigoVerificacion) {
        boolean verificado;
        if (codigoVerificacion == codigoGenerado) {
            JOptionPane.showMessageDialog(null, ">>> Acceso Permitido", "Exito", JOptionPane.INFORMATION_MESSAGE);
            verificado = true;
            codigoGenerado = -1;
        } else {
            JOptionPane.showMessageDialog(null, ">>> Acceso Denegado", "Error", JOptionPane.ERROR_MESSAGE);
            codigoGenerado = -1;
            verificado = false;
        }
        return verificado;
    }

    /**
     * Obtiene una lista de libros prestados en un mes específico.
     *
     * @param mes Mes para filtrar los libros prestados.
     * @return Lista de libros prestados en el mes indicado.
     */
    public List<Libro> librosPrestadosEnMes(int mes) {
        List<Libro> librosPrestadosEnMes = new ArrayList<>();
        if (biblioteca.getListPrestamos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay prestamos realizados", "Error", JOptionPane.ERROR_MESSAGE);
            return librosPrestadosEnMes;
        }
        for (Prestamo prestamos : biblioteca.getListPrestamos()) {
            if (prestamos.getFechaPrestamo().getMonthValue() == mes) {
                librosPrestadosEnMes.add(prestamos.getLibro());
            }
        }
        return librosPrestadosEnMes;
    }

    /**
     * Busca los usuarios con más préstamos realizados.
     *
     * @return Lista de usuarios con mayor cantidad de préstamos.
     */
    public List<Usuario> usuarioConMasPrestamosRealizados() {
        List<Usuario> usuariosConMasPrestamos = new ArrayList<>();
        int maxPrestamosUsuario = 0;
        if (biblioteca.getListUsuarios().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados", "Error", JOptionPane.ERROR_MESSAGE);
            return usuariosConMasPrestamos;
        }
        for (Usuario usuario : biblioteca.getListUsuarios()) {
            if (usuario instanceof Docente docente) {
                if (docente.getListHistorialPrestamosDocentes().size() > maxPrestamosUsuario) {
                    maxPrestamosUsuario = docente.getListHistorialPrestamosDocentes().size();
                }
            } else if (usuario instanceof Estudiante estudiante) {
                if (estudiante.getListHistorialPrestamosEstudiante().size() > maxPrestamosUsuario) {
                    maxPrestamosUsuario = estudiante.getListHistorialPrestamosEstudiante().size();
                }
            }
        }

        for (Usuario usuario : biblioteca.getListUsuarios()) {
            if (usuario instanceof Docente docente) {
                if (docente.getListHistorialPrestamosDocentes().size() == maxPrestamosUsuario) {
                    usuariosConMasPrestamos.add(docente);
                }
            } else if (usuario instanceof Estudiante estudiante) {
                if (estudiante.getListHistorialPrestamosEstudiante().size() == maxPrestamosUsuario) {
                    usuariosConMasPrestamos.add(estudiante);
                }
            }
        }
        return usuariosConMasPrestamos;
    }

    /**
     * Busca los libros registrados que no han sido prestados.
     *
     * @return Lista de libros sin préstamos.
     */
    public List<Libro> librosSinPrestamos() {
        List<Libro> librosSinPrestamos = new ArrayList<>();
        int vecesPrestado = 0;
        if (biblioteca.getListLibros().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros registrados", "Error", JOptionPane.ERROR_MESSAGE);
            return librosSinPrestamos;
        }
        for (Libro libro : biblioteca.getListLibros()) {
            if (libro instanceof IGestionPrestamo) {
                if (libro.getCantidadVecesPrestado() == vecesPrestado) {
                    librosSinPrestamos.add(libro);
                }
            }
        }
        return librosSinPrestamos;
    }

    /**
     * Obtiene la biblioteca asociada al administrador.
     *
     * @return Biblioteca asociada al administrador.
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * Actualiza la biblioteca asociada al administrador.
     *
     * @param biblioteca Biblioteca que será asignada al administrador.
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}




