package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void testActualizarListaLibros() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        LibroDigital libroDigital = new LibroDigital("El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía", 2010, EstadoLibro.DISPONIBLE, "djkajdkJ", FormatoLibro.PDF);
        LibroFisico libroFisico = new LibroFisico("Cien Años de Soledad", "Gabriel García Márquez", "Realismo Mágico", EstadoLibro.DISPONIBLE, 2000, 300, "na", "hh");
        LibroReferencia libroReferencia = new LibroReferencia("Diccionario de la RAE", "RAE", "Referencia", EstadoLibro.REFERENCIA, 2020);
        biblioteca.getListLibrosFisicos().add(libroFisico);
        biblioteca.getListLibrosDigitales().add(libroDigital);
        biblioteca.getListLibrosReferencia().add(libroReferencia);
        biblioteca.actualizarListaLibros();
        assertTrue(biblioteca.getListLibros().contains(libroFisico));

    }

    @Test
    void testActualizarListaUsuarios() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Docente docente = new Docente("Juan", "12345678", 20, "<EMAIL>", "962601234", "123456");
        Estudiante estudiante = new Estudiante("Juan", "12345678", 20, "<EMAIL>", "962601234", "123456");
        Visitante visitante = new Visitante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        biblioteca.getListDocentes().add(docente);
        biblioteca.getListEstudiantes().add(estudiante);
        biblioteca.getListVisitantes().add(visitante);
        biblioteca.actualizarListaUsuarios();
        assertTrue(biblioteca.getListUsuarios().contains(estudiante));
    }

    @Test
    void testActualizarListaEmpleados() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan", "12345", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        biblioteca.getListBibliotecarios().add(bibliotecario);
        biblioteca.getListAdministradores().add(administrador);
        biblioteca.actualizarListaEmpleados();
        assertTrue(biblioteca.getListEmpleados().contains(bibliotecario));
    }

    @Test
    void testBuscarLibro() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico = new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        bibliotecario.agregarLibroFisico(libroFisico);
        assertEquals(libroFisico, biblioteca.buscarLibro(libroFisico.getTitulo()));
    }

    @Test
    void testBuscarUsuario() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Estudiante estudiante = new Estudiante("Juan", "12345678", 20, "<EMAIL>", "962601234", "123456");
        bibliotecario.agregarEstudiante(estudiante);
        assertEquals(estudiante,biblioteca.buscarUsuario(estudiante.getIdentificacion()));
    }

    @Test
    void testIniciarSesionEmpleado() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Administrador administrador= new Administrador("Juan", "22135", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        biblioteca.agregarAdministrador(administrador);
        assertTrue(biblioteca.iniciarSesionEmpleado(administrador.getCredencial(),administrador.getContrasenia()));
    }

    @Test
    void testIniciarSesionUsuario() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        bibliotecario.agregarDocente(docente);
        assertTrue(biblioteca.iniciarSesionUsuario(docente.getIdentificacion(), docente.getContrasenia()));
        Usuario usuarioLogueado=biblioteca.getUsuarioLogueado();
        assertEquals(usuarioLogueado,docente);
    }


    @Test
    void testUsuarioExiste() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        bibliotecario.agregarDocente(docente);
        assertTrue(biblioteca.usuarioExiste(docente.getIdentificacion()));
    }

    @Test
    void testLibroExiste() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico=new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        bibliotecario.agregarLibroFisico(libroFisico);
        assertTrue(biblioteca.libroExiste(libroFisico.getTitulo()));
    }

    @Test
    void testAgregarAdministrador() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan", "12345", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        biblioteca.agregarAdministrador(administrador);
        assertTrue(biblioteca.getListAdministradores().contains(administrador));
    }

    @Test
    void testEliminarAdministrador() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan", "12345", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        biblioteca.agregarAdministrador(administrador);
        biblioteca.eliminarAdministrador(administrador.getIdentificacion());
        assertFalse(biblioteca.getListAdministradores().contains(administrador));
    }

    @Test
    void testActualizarAdministrador() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan", "12345", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        biblioteca.agregarAdministrador(administrador);
        Administrador nuevoAdministrador= new Administrador("Juan", "15675", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        assertTrue(biblioteca.actualizarAdministrador(administrador.getIdentificacion(),nuevoAdministrador));
    }

    @Test
    void testBuscarEmpleado() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Administrador administrador= new Administrador("Juan", "22135", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        biblioteca.agregarAdministrador(administrador);
        assertEquals(administrador,biblioteca.buscarEmpleado(administrador.getCredencial()));
    }
}