package co.edu.uniquindio.poo.bibliotecajfx.model;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Bibliotecario representa a un bibliotecario que hereda de la clase Empleado.
 * Es responsable de gestionar las operaciones relacionadas con una biblioteca,
 * como la gestión de libros, usuarios y préstamos.
 */
public class Bibliotecario extends Empleado {
    private Biblioteca biblioteca;


    /**
     * Construye un nuevo objeto Bibliotecario con los detalles especificados y la biblioteca asociada.
     *
     * @param nombre el nombre del bibliotecario
     * @param identificacion la identificación del bibliotecario
     * @param edad la edad del bibliotecario
     * @param correo la dirección de correo electrónico del bibliotecario
     * @param telefono el número de teléfono del bibliotecario
     * @param contrasenia la contraseña del bibliotecario
     * @param credencial las credenciales del bibliotecario
     * @param biblioteca el objeto Biblioteca asociado al bibliotecario
     */
    public Bibliotecario(String nombre, String identificacion, int edad, String correo, String telefono,String contrasenia, String credencial,Biblioteca biblioteca) {
        super(nombre, identificacion, edad, correo, telefono,contrasenia,credencial);
       this.biblioteca=biblioteca;
    }

   

    /**
     * Obtiene el objeto Biblioteca asociado al bibliotecario.
     *
     * @return el objeto Biblioteca relacionado con este bibliotecario
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }


    /**
     * Realiza un préstamo de un libro a un usuario específico, verificando las condiciones 
     * para distintos tipos de usuarios y la disponibilidad del libro.
     *
     * @param idUsuario la identificación del usuario que desea realizar el préstamo
     * @param tituloLibro el título del libro que desea ser prestado
     * @param fechaInicio la fecha de inicio del préstamo
     * @param fechaFin la fecha de fin del préstamo
     */
    public void realizarPrestamo(String idUsuario, String tituloLibro, LocalDate fechaInicio, LocalDate fechaFin) {
        if (prestamoExiste(idUsuario, tituloLibro)) {
            JOptionPane.showMessageDialog(null, "El préstamo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Usuario usuario = biblioteca.buscarUsuario(idUsuario);
        Libro libro = biblioteca.buscarLibro(tituloLibro);
        if (libro == null || usuario == null) {
            JOptionPane.showMessageDialog(null, "El libro o el usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (usuario instanceof Docente) {
            Docente docente = (Docente) usuario;
            if (!libro.estaDisponible() || !docente.puedePrestar()) {
                JOptionPane.showMessageDialog(null, "El libro no está disponible o el usuario no puede prestar", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (libro instanceof IGestionPrestamo) {
                Prestamo prestamo = new Prestamo(fechaInicio, fechaFin, libro, docente);
                prestamo.prestarLibro();
                docente.agregarPrestamo(prestamo);
                biblioteca.getListPrestamos().add(prestamo);

                JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Los libros de referencia no pueden ser prestados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            if (!libro.estaDisponible() || !estudiante.puedePrestar()) {
                JOptionPane.showMessageDialog(null, "El libro no está disponible o el usuario no puede prestar.", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (libro instanceof IGestionPrestamo) {
                Prestamo prestamo = new Prestamo(fechaInicio, fechaFin, libro, estudiante);
                prestamo.prestarLibro();
                estudiante.agregarPrestamo(prestamo);
                biblioteca.getListPrestamos().add(prestamo);
                JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Los libros de referencia no pueden ser prestados.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (usuario instanceof Visitante) {
            JOptionPane.showMessageDialog(null, "Los visitantes no pueden prestar libros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Verifica si existe un préstamo activo para el usuario especificado y el libro indicado.
     *
     * @param identificacion la identificación del usuario para el que se busca el préstamo
     * @param tituloLibro el título del libro para el que se busca el préstamo
     * @return true si existe un préstamo para el usuario y el libro especificados, false en caso contrario
     */
    public boolean prestamoExiste(String identificacion,String tituloLibro){
        for(int i=0;i<biblioteca.getListPrestamos().size();i++){
            if(biblioteca.getListPrestamos().get(i).getLibro().getTitulo().equalsIgnoreCase(tituloLibro) && biblioteca.getListPrestamos().get(i).getUsuario().getIdentificacion().equalsIgnoreCase(identificacion)  ){
                return true;
            }
        }
        return false;
    }

    /**
     * Procesa la devolución de un libro prestado por un usuario específico. 
     * Verifica que el usuario y el libro existan, busca el préstamo correspondiente 
     * y realiza la devolución, actualizando la lista de préstamos en consecuencia.
     *
     * @param idUsuario la identificación del usuario que está devolviendo el libro
     * @param tituloLibro el título del libro que se desea devolver
     */
    public void realizarDevolucion(String idUsuario, String tituloLibro) {
        Libro libro = biblioteca.buscarLibro(tituloLibro);
        Usuario usuario = biblioteca.buscarUsuario(idUsuario);

        if (libro == null) {
            JOptionPane.showMessageDialog(null, "Libro no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (usuario instanceof Docente docente) {
            for(int i=0;i<biblioteca.getListPrestamos().size();i++){
                if(biblioteca.getListPrestamos().get(i).getUsuario().getIdentificacion().equalsIgnoreCase(idUsuario) && biblioteca.getListPrestamos().get(i).getLibro().getTitulo().equalsIgnoreCase(tituloLibro)){
                    biblioteca.getListPrestamos().get(i).devolverLibro();
                    docente.libroDevuelto(biblioteca.getListPrestamos().get(i));
                    biblioteca.getListPrestamos().remove(biblioteca.getListPrestamos().get(i));


                }
            }
        }else if(usuario instanceof Estudiante estudiante){
            for(int j=0;j<biblioteca.getListPrestamos().size();j++){
                if(biblioteca.getListPrestamos().get(j).getUsuario().getIdentificacion().equalsIgnoreCase(idUsuario) && biblioteca.getListPrestamos().get(j).getLibro().getTitulo().equalsIgnoreCase(tituloLibro)){
                    biblioteca.getListPrestamos().get(j).devolverLibro();
                    estudiante.libroDevuelto(biblioteca.getListPrestamos().get(j));
                    biblioteca.getListPrestamos().remove(biblioteca.getListPrestamos().get(j));


                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Prestamo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Obtiene la lista de libros que están actualmente prestados en la biblioteca,
     * es decir, aquellos que no están disponibles.
     *
     * @return una lista de objetos de tipo Libro que representan los libros prestados
     */
    public List<Libro> librosPrestados() {
        List<Libro> libros = new ArrayList<>();
        for (int i = 0; i < biblioteca.getListPrestamos().size(); i++) {
            if (!biblioteca.getListPrestamos().get(i).getLibro().estaDisponible()) {
                libros.add(biblioteca.getListLibros().get(i));
            }
        }
        return libros;
    }

    /**
     * Obtiene una lista de usuarios que tienen préstamos vencidos en la biblioteca.
     * Este método recorre la lista de préstamos de la biblioteca, identifica aquellos
     * que están vencidos y agrega los usuarios relacionados a una nueva lista.
     *
     * @return una lista de objetos Usuario que representan a los usuarios con préstamos vencidos
     */
    public List<Usuario> UsuariosDeudores() {
        List<Usuario> usuariosConDeudas =new ArrayList<>();
        for(int i=0;i<biblioteca.getListUsuarios().size();i++){
            if(biblioteca.getListPrestamos().get(i).estaVencido()){
                usuariosConDeudas.add(biblioteca.getListPrestamos().get(i).getUsuario());
            }
        }
        return usuariosConDeudas;
    }
    /**
     * Identifica los libros más solicitados de la biblioteca basándose en la cantidad de veces
     * que han sido prestados. Este método busca todos los libros con la mayor cantidad de
     *  préstamos y los retorna en una lista.
     *
     * @return una lista de libros que han sido solicitados con mayor frecuencia. Si no hay 
     * libros o la biblioteca no tiene registro de préstamos, la lista retornada estará vacía.
     */
    public List<Libro> libroMasSolicitado() {
        List<Libro> libroMasSolicitado = new ArrayList<>();
        int maxCantidadVecesPrestado = 0;
        for (int i = 0; i < biblioteca.getListLibros().size(); i++) {

            if (biblioteca.getListLibros().get(i).getCantidadVecesPrestado() > maxCantidadVecesPrestado) {
                maxCantidadVecesPrestado = biblioteca.getListLibros().get(i).getCantidadVecesPrestado();
            }
        }
        for (int i = 0; i < biblioteca.getListLibros().size(); i++) {
            if (biblioteca.getListLibros().get(i).getCantidadVecesPrestado()== maxCantidadVecesPrestado){
                libroMasSolicitado.add(biblioteca.getListLibros().get(i));
            }
        }
        return libroMasSolicitado;
    }

    /**
     * Agrega un nuevo libro físico a la lista de libros físicos de la biblioteca asociada. 
     * Si el libro ya existe, muestra un mensaje de error indicando la duplicidad.
     *
     * @param libroFisico el objeto LibroFisico que se desea agregar a la biblioteca
     */
    public void agregarLibroFisico(LibroFisico libroFisico) {
        if (biblioteca.libroExiste(libroFisico.getTitulo())) {
            JOptionPane.showMessageDialog(null, "El libro ya existe","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            biblioteca.getListLibrosFisicos().add(libroFisico);
            biblioteca.actualizarListaLibros();
        }
    }

    /**
     * Elimina un libro físico de la lista de libros físicos en la biblioteca asociada. 
     * Si el libro con el título especificado es encontrado, se elimina de la lista,
     * y se actualizan las listas generales de libros y usuarios en la biblioteca.
     *
     * @param titulo el título del libro físico que se desea eliminar
     */
    public void eliminarLibroFisico(String titulo) {
        for(int i=0;i<biblioteca.getListLibrosFisicos().size();i++){
            if(biblioteca.getListLibrosFisicos().get(i).getTitulo().equalsIgnoreCase(titulo)){
                biblioteca.getListLibrosFisicos().remove(i);
                biblioteca.actualizarListaLibros();
                biblioteca.actualizarListaUsuarios();
                break;
            }
        }
    }

    /**
     * Actualiza un libro físico en la biblioteca asociada al bibliotecario, coincidiendo por título.
     * Si un libro con el título especificado existe en la lista de libros físicos de la biblioteca,
     * lo reemplaza con el libro proporcionado y actualiza la lista general de libros de la biblioteca.
     *
     * @param titulo      el título del libro físico que se debe actualizar
     * @param libroFisico el nuevo objeto LibroFisico para reemplazar el existente
     * @return true si el libro se actualizó correctamente, false si no se encontró un libro con el título especificado
     * @throws IllegalArgumentException si el libroFisico proporcionado es nulo
     */
    public boolean actualizarLibroFisico(String titulo, LibroFisico libroFisico) {
        if (libroFisico == null) {
            throw new IllegalArgumentException("El libro físico proporcionado no puede ser nulo.");
        }
        for (int i = 0; i < biblioteca.getListLibrosFisicos().size(); i++) {
            if (biblioteca.getListLibrosFisicos().get(i).getTitulo().equalsIgnoreCase(titulo)) {
                biblioteca.getListLibrosFisicos().set(i, libroFisico);
                biblioteca.actualizarListaLibros();
                return true;
            }
        }
        return false;
    }
    /**
     * Agrega un nuevo libro digital a la lista de libros digitales de la biblioteca asociada 
     * al bibliotecario. Si el libro ya existe en la colección, muestra un mensaje de error 
     * indicando la duplicidad. En caso contrario, agrega el libro a la lista y actualiza 
     * la lista general de libros en la biblioteca.
     *
     * @param libroDigital el objeto LibroDigital que se desea agregar a la biblioteca
     */
    public void agregarLibroDigital(LibroDigital libroDigital) {
        if (biblioteca.libroExiste(libroDigital.getTitulo())) {
            JOptionPane.showMessageDialog(null, "El libro ya existe","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            biblioteca.getListLibrosDigitales().add(libroDigital);
            biblioteca.actualizarListaLibros();
        }
    }


    /**
     * Elimina un libro digital de la lista de libros digitales en la biblioteca asociada.
     * Si el libro con el título especificado se encuentra, este es removido de la lista
     * y se actualiza la lista general de libros en la biblioteca.
     *
     * @param titulo El título del libro digital que se desea eliminar.
     */
    public void eliminarLibroDigital(String titulo) {
        for(int i=0;i<biblioteca.getListLibrosDigitales().size();i++){
            if(biblioteca.getListLibrosDigitales().get(i).getTitulo().equalsIgnoreCase(titulo)){
                biblioteca.getListLibrosDigitales().remove(i);
                biblioteca.actualizarListaLibros();
                break;
            }
        }
    }

    /**
     * Actualiza un libro digital en la lista de libros digitales de la biblioteca asociada al bibliotecario.
     * Si un libro con el título especificado existe en la lista, es reemplazado por el nuevo libro digital proporcionado.
     * Además, se actualiza la lista general de libros en la biblioteca.
     *
     * @param titulo el título del libro digital que se debe actualizar
     * @param libroDigitalibroDigital el nuevo objeto LibroDigital para reemplazar el existente en la lista
     * @return true si el libro digital fue actualizado correctamente, false si no se encontró un libro con el título especificado
     */
    public boolean actualizarLibroDigital(String titulo, LibroDigital libroDigitalibroDigital) {
        for(int i=0;i<biblioteca.getListLibrosDigitales().size();i++){
            if(biblioteca.getListLibrosDigitales().get(i).getTitulo().equalsIgnoreCase(titulo)){
                biblioteca.getListLibrosDigitales().set(i, libroDigitalibroDigital);
                biblioteca.actualizarListaLibros();
                return true;

            }
        }
        return false;
    }

    /**
     * Agrega un libro de referencia a la lista de libros de referencia
     * en la biblioteca asociada al bibliotecario. Si un libro con el
     * mismo título ya existe en la biblioteca, muestra un mensaje de error.
     *
     * @param libroReferencia el objeto LibroReferencia que se desea agregar a la biblioteca
     */
    public void agregarLibroReferencia(LibroReferencia libroReferencia) {
        if (biblioteca.libroExiste(libroReferencia.getTitulo())) {
            JOptionPane.showMessageDialog(null, "El libro ya existe","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            biblioteca.getListLibrosReferencia().add(libroReferencia);
            biblioteca.actualizarListaLibros();
        }
    }


    /**
     * Elimina un libro de referencia de la lista de libros de referencia en la biblioteca asociada.
     * Si se encuentra un libro cuyo título coincide con el especificado, se elimina de la lista
     * y se actualiza la lista general de libros en la biblioteca.
     *
     * @param titulo el título del libro de referencia que se desea eliminar
     */
    public void eliminarLibroReferencia(String titulo) {
        for (int i = 0; i < biblioteca.getListLibrosReferencia().size(); i++) {
            if (biblioteca.getListLibrosReferencia().get(i).getTitulo().equalsIgnoreCase(titulo)) {
                biblioteca.getListLibrosReferencia().remove(i);
                biblioteca.actualizarListaLibros();
                break;
            }
        }
    }

    /**
     * Actualiza un libro de referencia en la lista de libros de referencia de la biblioteca asociada.
     * Reemplaza el libro que coincide con el título especificado por el nuevo objeto de libro de referencia.
     * También actualiza la lista general de libros de la biblioteca.
     *
     * @param titulo el título del libro de referencia que se debe actualizar
     * @param libroReferencia el nuevo objeto LibroReferencia para reemplazar el existente
     */
    public void actualizarLibroReferencia(String titulo, LibroReferencia libroReferencia) {
        for (int i = 0; i < biblioteca.getListLibrosReferencia().size(); i++) {
            if (biblioteca.getListLibrosReferencia().get(i).getTitulo().equalsIgnoreCase(titulo)) {
                biblioteca.getListLibrosReferencia().set(i, libroReferencia);
                biblioteca.actualizarListaLibros();
                break;
            }
        }
    }

    /**
     * Agrega un nuevo docente a la lista de docentes de la biblioteca asociada.
     * Si el docente ya existe en el sistema, muestra un mensaje de error indicando la duplicidad.
     * En caso contrario, agrega el docente a la lista y actualiza la lista general de usuarios en la biblioteca.
     *
     * @param docente el objeto Docente que se desea agregar a la biblioteca
     */
    public void agregarDocente(Docente docente){
        if(biblioteca.usuarioExiste(docente.getIdentificacion())){
            JOptionPane.showMessageDialog(null, "El usuario ya existe","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            biblioteca.getListDocentes().add(docente);
            biblioteca.actualizarListaUsuarios();
        }
    }

    /**
     * Elimina un docente de la lista de docentes de la biblioteca asociada al bibliotecario.
     * Si se encuentra un docente con la identificación especificada, este se elimina de la lista
     * y la lista general de usuarios en la biblioteca es actualizada.
     *
     * @param idUsuario la identificación del docente que se desea eliminar
     */
    public void eliminarDocente(String idUsuario){
        for(int i=0;i<biblioteca.getListDocentes().size();i++){
            if(biblioteca.getListDocentes().get(i).getIdentificacion().equalsIgnoreCase(idUsuario)){
                biblioteca.getListDocentes().remove(i);
                biblioteca.actualizarListaUsuarios();
                break;
            }
        }
    }
    /**
     * Updates a docente (teacher) in the library system if the provided ID matches an existing docente.
     * If a docente with the given ID is found, their details are updated with the provided docente object.
     * The list of users in the library system is then updated to reflect this change.
     *
     * @param idUsuario the unique identifier of the docente to update
     * @param docente the updated details of the docente to replace the existing one
     * @return true if the docente was successfully updated, false if no docente with the provided ID was found
     */
    public boolean actualizarDocente(String idUsuario, Docente docente){
        for(int i=0;i<biblioteca.getListDocentes().size();i++){
            if(biblioteca.getListDocentes().get(i).getIdentificacion().equalsIgnoreCase(idUsuario)){
                biblioteca.getListDocentes().set(i, docente);
                biblioteca.actualizarListaUsuarios();
                return true;
            }
        }
        return false;
    }
    /**
     * Agrega un nuevo estudiante a la lista de estudiantes de la biblioteca asociada.
     * Si el estudiante ya existe según su identificación, muestra un mensaje de error.
     * De lo contrario, lo agrega a la lista y actualiza la lista de usuarios de la biblioteca.
     *
     * @param estudiante el objeto Estudiante que se desea agregar a la biblioteca
     */
    public void agregarEstudiante(Estudiante estudiante){
        if(biblioteca.usuarioExiste(estudiante.getIdentificacion())){
            JOptionPane.showMessageDialog(null, "El usuario ya existe","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            biblioteca.getListEstudiantes().add(estudiante);
            biblioteca.actualizarListaUsuarios();
        }
    }
    /**
     * Elimina un estudiante de la lista de estudiantes en la biblioteca asociada.
     * Si un estudiante con la identificación proporcionada es encontrado, este será eliminado
     * y la lista general de usuarios de la biblioteca será actualizada.
     *
     * @param idUsuario la identificación del estudiante que se desea eliminar
     */
    public void eliminarEstudiante(String idUsuario){
        for(int i=0;i<biblioteca.getListEstudiantes().size();i++){
            if(biblioteca.getListEstudiantes().get(i).getIdentificacion().equalsIgnoreCase(idUsuario)){
                biblioteca.getListEstudiantes().remove(i);
                biblioteca.actualizarListaUsuarios();
                break;
            }
        }
    }
    /**
     * Actualiza la información de un estudiante en la lista de estudiantes de la biblioteca
     * asociada al bibliotecario. Reemplaza al estudiante existente identificado con el ID
     * especificado con los nuevos datos proporcionados.
     *
     * @param idUsuario la identificación del estudiante que se desea actualizar
     * @param estudiante un objeto Estudiante con los nuevos datos que reemplazarán al estudiante existente
     * @return true si el estudiante fue encontrado y actualizado correctamente, false si no se encontró un estudiante con la identificación proporcionada
     */
    public boolean actualizarEstudiante(String idUsuario,Estudiante estudiante){
        for(int i=0;i<biblioteca.getListEstudiantes().size();i++){
            if(biblioteca.getListEstudiantes().get(i).getIdentificacion().equalsIgnoreCase(idUsuario)){
                biblioteca.getListEstudiantes().set(i,estudiante);
                biblioteca.actualizarListaUsuarios();
                return true;
            }
        }
        return false;
    }
    /**
     * Agrega un nuevo visitante a la lista de visitantes de la biblioteca asociada al bibliotecario.
     * Si el visitante ya existe basado en su identificación, muestra un mensaje de error.
     * De lo contrario, agrega el visitante a la lista y actualiza la lista de usuarios.
     *
     * @param visitante el objeto Visitante que se desea agregar a la biblioteca
     */
    public void agregarVisitante(Visitante visitante){
        if(biblioteca.usuarioExiste(visitante.getIdentificacion())){
            JOptionPane.showMessageDialog(null, "El usuario ya existe","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            biblioteca.getListVisitantes().add(visitante);
            biblioteca.actualizarListaUsuarios();
        }
    }
    /**
     * Elimina un visitante de la lista de visitantes de la biblioteca
     * asociada al bibliotecario si su identificación coincide con la proporcionada.
     * Después de eliminar al visitante, actualiza la lista general de usuarios en la biblioteca.
     *
     * @param idUsuario la identificación del visitante que se desea eliminar
     */
    public void eliminarVisitante(String idUsuario){
        for(int i=0;i<biblioteca.getListVisitantes().size();i++){
            if(biblioteca.getListVisitantes().get(i).getIdentificacion().equalsIgnoreCase(idUsuario)){
                biblioteca.getListVisitantes().remove(i);
                biblioteca.actualizarListaUsuarios();
                break;
            }
        }
    }
    /**
     * Actualiza la información de un visitante en la lista de visitantes de la biblioteca
     * asociada al bibliotecario, utilizando la identificación del usuario para localizarlo.
     * Si el visitante es encontrado, se actualiza su información y se actualiza también
     * la lista de usuarios en la biblioteca.
     *
     * @param idUsuario la identificación del visitante que se desea actualizar
     * @param visitante el objeto Visitante que contiene la nueva información a actualizar
     * @return true si el visitante fue encontrado y actualizado correctamente, false en caso contrario
     */
    public boolean actualizarVisitante(String idUsuario,Visitante visitante){
        for(int i=0;i<biblioteca.getListVisitantes().size();i++){
            if(biblioteca.getListVisitantes().get(i).getIdentificacion().equalsIgnoreCase(idUsuario)){
                biblioteca.getListVisitantes().set(i,visitante);
                biblioteca.actualizarListaUsuarios();
                return true;
            }
        }
        return false;
    }






    /**
     * Devuelve una representación en formato de texto del objeto Bibliotecario,
     * incluyendo el nombre de la biblioteca asociada.
     *
     * @return una cadena de texto que representa al objeto Bibliotecario
     * e incluye el nombre de la biblioteca asociada.
     */
    @Override
    public String toString() {
        return "Bibliotecario{"+
                "biblioteca=" + biblioteca.getNombre() +
                '}';
    }
}


