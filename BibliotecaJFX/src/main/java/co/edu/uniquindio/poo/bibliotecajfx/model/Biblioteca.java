package co.edu.uniquindio.poo.bibliotecajfx.model;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un sistema de biblioteca que gestiona diversas entidades,
 * incluyendo usuarios, libros, préstamos y empleados.
 * Esta clase proporciona funcionalidad para gestionar y actualizar estas entidades,
 * así como para buscar libros, empleados o usuarios.
 * También soporta la iniciación de sesión para usuarios y empleados.
 */
public class Biblioteca {
    private String nombre;
    private List<Prestamo> listPrestamos;
    private List<Docente> listDocentes;
    private List<Estudiante> listEstudiantes;
    private List<Visitante> listVisitantes;
    private List<Administrador> listAdministradores;
    private List<Bibliotecario> listBibliotecarios;
    private List<LibroDigital> listLibrosDigitales;
    private List<LibroFisico> listLibrosFisicos;
    private List<LibroReferencia> listLibrosReferencia;
    private List<Libro> listLibros;
    private List<Usuario> listUsuarios;
    private List<Empleado> listEmpleados;
    private Usuario usuarioLogueado;

    /**
     * Constructor para crear una nueva instancia de Biblioteca.
     *
     * @param nombre Nombre de la biblioteca.
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.listPrestamos = new ArrayList<>();
        this.listDocentes = new ArrayList<>();
        this.listVisitantes = new ArrayList<>();
        this.listEstudiantes = new ArrayList<>();
        this.listAdministradores = new ArrayList<>();
        this.listBibliotecarios = new ArrayList<>();
        this.listLibrosDigitales = new ArrayList<>();
        this.listLibrosFisicos = new ArrayList<>();
        this.listLibrosReferencia = new ArrayList<>();
        this.listLibros = new ArrayList<>();
        this.listUsuarios = new ArrayList<>();
        this.listEmpleados = new ArrayList<>();
        this.usuarioLogueado = null;
        assert nombre != null;
    }

    /**
     * Actualiza la lista general de libros combinando las listas de libros digitales, físicos y de referencia.
     */
    public void actualizarListaLibros() {
        listLibros.clear();
        if (listLibrosDigitales != null) {
            listLibros.addAll(listLibrosDigitales);
        }
        if (listLibrosFisicos != null) {
            listLibros.addAll(listLibrosFisicos);
        }
        if (listLibrosReferencia != null) {
            listLibros.addAll(listLibrosReferencia);
        }
    }

    /**
     * Actualiza la lista general de usuarios combinando las listas de docentes, estudiantes y visitantes.
     */
    public void actualizarListaUsuarios() {
        listUsuarios.clear();
        if (listDocentes != null) {
            listUsuarios.addAll(listDocentes);
        }
        if (listEstudiantes != null) {
            listUsuarios.addAll(listEstudiantes);
        }
        if (listVisitantes != null) {
            listUsuarios.addAll(listVisitantes);
        }
    }

    /**
     * Actualiza la lista general de empleados combinando las listas de administradores y bibliotecarios.
     */
    public void actualizarListaEmpleados() {
        listEmpleados.clear();
        if (listAdministradores != null) {
            listEmpleados.addAll(listAdministradores);
        }
        if (listBibliotecarios != null) {
            listEmpleados.addAll(listBibliotecarios);
        }
    }

    /**
     * Busca un libro por su título.
     *
     * @param titulo Título del libro.
     * @return El libro encontrado o null si no existe.
     */
    public Libro buscarLibro(String titulo) {
        for (Libro libro : listLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Busca un empleado por su credencial.
     *
     * @param credencial Credencial del empleado.
     * @return El empleado encontrado o null si no existe.
     */
    public Empleado buscarEmpleado(String credencial) {
        for (Empleado empleado : listEmpleados) {
            if (empleado.getCredencial().equalsIgnoreCase(credencial)) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Busca un usuario por su identificación.
     *
     * @param identificacion Identificación del usuario.
     * @return El usuario encontrado o null si no existe.
     */
    public Usuario buscarUsuario(String identificacion) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Obtiene la lista de préstamos de la biblioteca.
     *
     * @return Lista de préstamos.
     */
    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    /**
     * Actualiza la lista de préstamos de la biblioteca.
     *
     * @param listPrestamos Lista de préstamos actualizada a establecer.
     */
    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }

    /**
     * Obtiene la lista de docentes de la biblioteca.
     *
     * @return Lista de docentes.
     */
    public List<Docente> getListDocentes() {
        return listDocentes;
    }

    /**
     * Actualiza la lista de docentes de la biblioteca.
     *
     * @param listDocentes Lista de docentes actualizada a establecer.
     */
    public void setListDocentes(List<Docente> listDocentes) {
        this.listDocentes = listDocentes;
    }

    /**
     * Obtiene la lista de visitantes de la biblioteca.
     *
     * @return Lista de visitantes.
     */
    public List<Visitante> getListVisitantes() {
        return listVisitantes;
    }

    /**
     * Actualiza la lista de visitantes de la biblioteca.
     *
     * @param listVisitantes Lista de visitantes actualizada a establecer.
     */
    public void setListVisitantes(List<Visitante> listVisitantes) {
        this.listVisitantes = listVisitantes;
    }

    /**
     * Obtiene la lista de libros digitales de la biblioteca.
     *
     * @return Lista de libros digitales.
     */
    public List<LibroDigital> getListLibrosDigitales() {
        return listLibrosDigitales;
    }

    /**
     * Actualiza la lista de libros digitales de la biblioteca.
     *
     * @param listLibrosDigitales Lista de libros digitales actualizada a establecer.
     */
    public void setListLibrosDigital(List<LibroDigital> listLibrosDigitales) {
        this.listLibrosDigitales = listLibrosDigitales;
    }

    /**
     * Obtiene la lista de libros físicos de la biblioteca.
     *
     * @return Lista de libros físicos.
     */
    public List<LibroFisico> getListLibrosFisicos() {
        return listLibrosFisicos;
    }

    /**
     * Actualzia la lista de libros físicos de la biblioteca.
     *
     * @param listLibrosFisicos Lista de libros físicos actualizada a establecer.
     */
    public void setListLibrosFisicos(List<LibroFisico> listLibrosFisicos) {
        this.listLibrosFisicos = listLibrosFisicos;
    }

    /**
     * Obtiene la lista de libros de referencia de la biblioteca.
     *
     * @return Lista de libros de referencia.
     */
    public List<LibroReferencia> getListLibrosReferencia() {
        return listLibrosReferencia;
    }

    /**
     * Actualiza la lista de libros de referencia de la biblioteca.
     *
     * @param listLibrosReferencia Lista de libros de referencia actualizada a establecer.
     */
    public void setListLibrosReferencia(List<LibroReferencia> listLibrosReferencia) {
        this.listLibrosReferencia = listLibrosReferencia;
    }

    /**
     * Obtiene el nombre de la biblioteca.
     *
     * @return Nombre de la biblioteca.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre de la biblioteca.
     *
     * @param nombre Nombre de la biblioteca actualizado a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de estudiantes de la biblioteca.
     *
     * @return Lista de estudiantes.
     */
    public List<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    /**
     * Obtiene la lista de administradores de la biblioteca.
     *
     * @return Lista de administradores.
     */
    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    /**
     * Obtiene la lista de bibliotecarios de la biblioteca.
     *
     * @return Lista de bibliotecarios.
     */
    public List<Bibliotecario> getListBibliotecarios() {
        return listBibliotecarios;
    }

    /**
     * Obtiene la lista general de libros de la biblioteca.
     *
     * @return Lista general de libros.
     */
    public List<Libro> getListLibros() {
        return listLibros;
    }

    /**
     * Obtiene la lista de usuarios de la biblioteca.
     *
     * @return Lista de usuarios.
     */
    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    /**
     * Obtiene el usuario actualmente logueado en la biblioteca.
     *
     * @return Usuario logueado.
     */
    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    /**
     *Actualiza el usuario actualmente logueado en la biblioteca.
     *
     * @param usuarioLogueado Usuario logueado actualizado a establecer.
     */
    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    /**
     * Actualiza la lista de bibliotecarios de la biblioteca.
     *
     * @param listBibliotecarios Lista de bibliotecarios actualizada a establecer.
     */
    public void setListBibliotecarios(List<Bibliotecario> listBibliotecarios) {
        this.listBibliotecarios = listBibliotecarios;
    }

    /**
     * Actuaaliza la lista de estudiantes de la biblioteca.
     *
     * @param listEstudiantes Lista de estudiantes actualizada a establecer.
     */
    public void setListEstudiantes(List<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    /**
     * Actualiza la lista de empleados de la biblioteca.
     *
     * @param listEmpleados Lista de empleados actualizada a establecer.
     */
    public void setListEmpleados(List<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }

    /**
     * Actualiza la lista general de libros de la biblioteca.
     *
     * @param listLibros Lista general de libros actualizada a establecer.
     */
    public void setListLibros(List<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    /**
     * Actualiza la lista de libros digitales de la biblioteca.
     *
     * @param listLibrosDigitales Lista de libros digitales actualizada a establecer.
     */
    public void setListLibrosDigitales(List<LibroDigital> listLibrosDigitales) {
        this.listLibrosDigitales = listLibrosDigitales;
    }

    /**
     * Actualiza la lista de usuarios de la biblioteca.
     *
     * @param listUsuarios Lista de usuarios actualizada a establecer.
     */
    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    /**
     * Actualiza la lista de administradores de la biblioteca.
     *
     * @param listAdministradores Lista de administradores actualizada a establecer.
     */
    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    /**
     * Verifica si se puede iniciar sesión con la credencial y contraseña de un empleado.
     *
     * @param credencial  Credencial del empleado.
     * @param contrasenia Contraseña del empleado.
     * @return true si el inicio de sesión es exitoso, de lo contrario false.
     */
    public boolean iniciarSesionEmpleado(String credencial, String contrasenia) {
        if (EmpleadoExiste(credencial)) {
            for (int i = 0; i < listEmpleados.size(); i++) {
                if (listEmpleados.get(i).getCredencial().equalsIgnoreCase(credencial) && listEmpleados.get(i).getContrasenia().equalsIgnoreCase(contrasenia)) {
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La credencial es incorrecta o el usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Verifica si se puede iniciar sesión con la identificación y contraseña de un usuario.
     *
     * @param identificacion Identificación del usuario.
     * @param contrasenia    Contraseña del usuario.
     * @return true si el inicio de sesión es exitoso, de lo contrario false.
     */
    public boolean iniciarSesionUsuario(String identificacion, String contrasenia) {
        if (usuarioExiste(identificacion)) {
            for (int i = 0; i < listUsuarios.size(); i++) {
                if (listUsuarios.get(i).getIdentificacion().equalsIgnoreCase(identificacion) && listUsuarios.get(i).getContrasenia().equalsIgnoreCase(contrasenia)) {
                    usuarioLogueado = listUsuarios.get(i);
                    return true;
                }
            }
            JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La credencial es incorrecta o el usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Verifica si un empleado existe en la lista de empleados a través de su credencial.
     *
     * @param credencial Credencial del empleado.
     * @return true si el empleado existe, de lo contrario false.
     */
    public boolean EmpleadoExiste(String credencial) {
        for (int i = 0; i < listEmpleados.size(); i++) {
            if (listEmpleados.get(i).getCredencial().equalsIgnoreCase(credencial)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si un usuario existe en la lista de usuarios a través de su identificación.
     *
     * @param idUsuario Identificación del usuario.
     * @return true si el usuario existe, de lo contrario false.
     */
    public boolean usuarioExiste(String idUsuario) {
        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).getIdentificacion().equalsIgnoreCase(idUsuario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si un libro existe en la lista de libros a través de su título.
     *
     * @param tituloLibro Título del libro.
     * @return true si el libro existe, de lo contrario false.
     */
    public boolean libroExiste(String tituloLibro) {
        for (int i = 0; i < listLibros.size(); i++) {
            if (listLibros.get(i).getTitulo().equalsIgnoreCase(tituloLibro)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega un administrador a la lista de administradores si no existe previamente.
     *
     * @param administrador Administrador a agregar.
     */
    public void agregarAdministrador(Administrador administrador) {
        if (usuarioExiste(administrador.getIdentificacion())) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            listAdministradores.add(administrador);
            actualizarListaEmpleados();
        }
    }

    /**
     * Elimina un administrador de la lista de administradores a través de su identificación.
     *
     * @param identificacion Identificación del administrador a eliminar.
     */
    public void eliminarAdministrador(String identificacion) {
        for (int i = 0; i < listAdministradores.size(); i++) {
            if (listAdministradores.get(i).getIdentificacion().equalsIgnoreCase(identificacion)) {
                listAdministradores.remove(i);
                actualizarListaEmpleados();
                break;
            }
        }
    }

    /**
     * Actualiza un administrador encontrado por su identificación.
     *
     * @param identificacion Identificación del administrador a actualizar.
     * @param administrador  Nuevos datos del administrador.
     * @return true si la actualización fue exitosa, de lo contrario false.
     */
    public boolean actualizarAdministrador(String identificacion, Administrador administrador) {
        for (int i = 0; i < listAdministradores.size(); i++) {
            if (listAdministradores.get(i).getIdentificacion().equalsIgnoreCase(identificacion)) {
                listAdministradores.set(i, administrador);
                actualizarListaEmpleados();
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista de empleados.
     *
     * @return una lista de objetos Empleado que representa a los empleados.
     */
    public List<Empleado> getListEmpleados() {
        return listEmpleados;
    }


    /**
     *    Metodo toString devuelve la información de la biblioteca como una cadena.
     *
     * @return Una cadena representando la biblioteca.
     */
    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", listDocentes=" + listDocentes +
                ", listVisitantes=" + listVisitantes +
                ", listLibrosDigital=" + listLibrosDigitales +
                ", listLibrosFisicos=" + listLibrosFisicos +
                ", listLibrosReferencia=" + listLibrosReferencia +
                '}';
    }
}
