package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestBibliotecario {

    @Test
    void testLibroMasSolicitado() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficcion", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroDigital libroDigital2 = new LibroDigital("El juego del ángel", "Carlos", "Drama", 2008, EstadoLibro.DISPONIBLE, "id2134asfg", FormatoLibro.EPUB);
        LibroFisico libroFisico = new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        LibroReferencia libroReferencia = new LibroReferencia("Enciclopedia Británica", "Varios Autores", "Referencia", null, 2010);

        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroDigital(libroDigital2);
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarLibroReferencia(libroReferencia);
        libroDigital1.setCantidadVecesPrestado(100);
        libroDigital2.setCantidadVecesPrestado(78);
        libroFisico.setCantidadVecesPrestado(89);
        libroReferencia.setCantidadVecesPrestado(12);
        List<Libro> librosMasSolicitados = bibliotecario.libroMasSolicitado();
        assertTrue(librosMasSolicitados.contains(libroDigital1));

    }

    @Test
    void testRealizarPrestamo() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficcion", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroReferencia libroReferencia = new LibroReferencia("Enciclopedia Británica", "Varios Autores", "Referencia", null, 2010);
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaMax = LocalDate.now().plusDays(10);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroReferencia(libroReferencia);
        bibliotecario.agregarDocente(docente);
        biblioteca.actualizarListaUsuarios();
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital1.getTitulo(), fechaInicio, fechaMax);
        assertEquals(1, biblioteca.getListPrestamos().size());

    }


    @Test
    void testRealizarDevolucion() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroFisico libroFisico = new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarDocente(docente);
        biblioteca.actualizarListaUsuarios();
        LocalDate fechaInicio = LocalDate.now().minusDays(10);
        LocalDate fechaMax = LocalDate.now().minusDays(5);
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital1.getTitulo(), fechaInicio, fechaMax);
        bibliotecario.realizarDevolucion(docente.getIdentificacion(), libroDigital1.getTitulo());
        assertEquals(0, biblioteca.getListPrestamos().size());
    }

    @Test
    void testLibrosPrestados() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficcion", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroDigital libroDigital2 = new LibroDigital("El juego del ángel", "Carlos", "Drama", 2008, EstadoLibro.DISPONIBLE, "id2134asfg", FormatoLibro.EPUB);
        LibroFisico libroFisico = new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        LibroReferencia libroReferencia = new LibroReferencia("Enciclopedia Británica", "Varios Autores", "Referencia", null, 2010);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroDigital(libroDigital2);
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarLibroReferencia(libroReferencia);
        bibliotecario.agregarDocente(docente);
        biblioteca.actualizarListaUsuarios();
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital1.getTitulo(), LocalDate.now(), LocalDate.now().plusDays(10));
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital2.getTitulo(), LocalDate.now(), LocalDate.now().plusDays(10));
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroFisico.getTitulo(), LocalDate.now(), LocalDate.now().plusDays(10));
        List<Libro> librosPrestados = bibliotecario.librosPrestados();
        assertEquals(3, librosPrestados.size());

    }

    @Test
    void testUsuariosDeudores() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        Estudiante estudiante = new Estudiante("Jose", "29242432", 16, "example@example.com", "81930139", "123");
        Estudiante estudiante1 = new Estudiante("Andres", "17219792", 26, "ahsjhsa@uq", "1973173", "juan891");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficcion", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroDigital libroDigital2 = new LibroDigital("El juego del ángel", "Carlos", "Drama", 2008, EstadoLibro.DISPONIBLE, "id2134asfg", FormatoLibro.EPUB);
        LibroFisico libroFisico = new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroDigital(libroDigital2);
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarDocente(docente);
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarEstudiante(estudiante1);
        biblioteca.actualizarListaUsuarios();
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital1.getTitulo(), LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
        bibliotecario.realizarPrestamo(estudiante1.getIdentificacion(), libroDigital2.getTitulo(), LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
        bibliotecario.realizarPrestamo(estudiante.getIdentificacion(), libroFisico.getTitulo(), LocalDate.now().minusDays(10), LocalDate.now().minusDays(5));
        List<Usuario> listUsuariosDeudores = bibliotecario.UsuariosDeudores();
        assertEquals(3, listUsuariosDeudores.size());

    }

    @Test
    void testAgregarLibroFisico() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico = new LibroFisico("Cien años de soledad", "Gabriel García Márquez", "Clasico", EstadoLibro.DISPONIBLE, 1967, 500, "Editorial Sudamericana", "Estante 4B");
        bibliotecario.agregarLibroFisico(libroFisico);
        assertTrue(biblioteca.getListLibros().contains(libroFisico));
    }

    @Test
    void testEliminarLibroFisico() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico = new LibroFisico("Cien años de soledad", "Gabriel García Márquez", "Clasico", EstadoLibro.DISPONIBLE, 1967, 500, "Editorial Sudamericana", "Estante 4B");
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.eliminarLibroFisico(libroFisico.getTitulo());
        assertFalse(biblioteca.getListLibros().contains(libroFisico));
    }

    @Test
    void testActualizarLibroFisico() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico = new LibroFisico("Cien años de soledad", "Gabriel García Márquez", "Clasico", EstadoLibro.DISPONIBLE, 1967, 500, "Editorial Sudamericana", "Estante 4B");
        bibliotecario.agregarLibroFisico(libroFisico);
        LibroFisico libroActualizado = new LibroFisico("Cien años de soledad", "Gabriel García Márquez", "Realismo Mágico", EstadoLibro.DISPONIBLE, 1967, 600, "Editorial Sudamericana", "Estante 4C");
        bibliotecario.actualizarLibroFisico(libroFisico.getTitulo(), libroActualizado);
        assertTrue(biblioteca.getListLibros().contains(libroActualizado));
        assertFalse(biblioteca.getListLibros().contains(libroFisico));

    }

    @Test
    void testAgregarLibroDigital() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroDigital libroDigital = new LibroDigital("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, EstadoLibro.DISPONIBLE, "abc123pdf", FormatoLibro.PDF);
        bibliotecario.agregarLibroDigital(libroDigital);
        assertTrue(biblioteca.getListLibros().contains(libroDigital));
    }

    @Test
    void testEliminarLibroDigital() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroDigital libroDigital = new LibroDigital("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, EstadoLibro.DISPONIBLE, "abc123pdf", FormatoLibro.PDF);
        bibliotecario.agregarLibroDigital(libroDigital);
        bibliotecario.eliminarLibroDigital(libroDigital.getTitulo());
        assertFalse(biblioteca.getListLibros().contains(libroDigital));
    }

    @Test
    void testActualizarLibroDigital() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroDigital libroDigital = new LibroDigital("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, EstadoLibro.DISPONIBLE, "abc123pdf", FormatoLibro.PDF);
        bibliotecario.agregarLibroDigital(libroDigital);
        LibroDigital libroActualizado = new LibroDigital("The Great Gatsby", "F. Scott Fitzgerald", "Classic Fiction", 1925, EstadoLibro.DISPONIBLE, "abc123epub", FormatoLibro.EPUB);
        bibliotecario.actualizarLibroDigital(libroDigital.getTitulo(), libroActualizado);
        assertTrue(biblioteca.getListLibros().contains(libroActualizado));
        assertFalse(biblioteca.getListLibros().contains(libroDigital));
    }

    @Test
    void testAgregarLibroReferencia() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroReferencia libroReferencia = new LibroReferencia("Encyclopedia", "Various", "Reference", null, 2020);
        bibliotecario.agregarLibroReferencia(libroReferencia);
        assertTrue(biblioteca.getListLibros().contains(libroReferencia));
    }

    @Test
    void testEliminarLibroReferencia() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroReferencia libroReferencia = new LibroReferencia("Encyclopedia", "Various", "Reference", null, 2020);
        bibliotecario.agregarLibroReferencia(libroReferencia);
        bibliotecario.eliminarLibroReferencia(libroReferencia.getTitulo());
        assertFalse(biblioteca.getListLibros().contains(libroReferencia));
    }

    @Test
    void testActualizarLibroReferencia() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroReferencia libroReferencia = new LibroReferencia("Encyclopedia", "Various", "Reference", null, 2020);
        bibliotecario.agregarLibroReferencia(libroReferencia);
        LibroReferencia libroActualizado = new LibroReferencia("Encyclopedia Updated", "Various", "Reference", null, 2021);
        bibliotecario.actualizarLibroReferencia(libroReferencia.getTitulo(), libroActualizado);
        assertTrue(biblioteca.getListLibros().contains(libroActualizado));
        assertFalse(biblioteca.getListLibros().contains(libroReferencia));
    }

    @Test
    void testAgregarDocente() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        bibliotecario.agregarDocente(docente);
        assertTrue(biblioteca.getListUsuarios().contains(docente));
    }

    @Test
    void testEliminarDocente() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        bibliotecario.agregarDocente(docente);
        bibliotecario.eliminarDocente(docente.getIdentificacion());
        assertFalse(biblioteca.getListUsuarios().contains(docente));
    }

    @Test
    void testActualizarDocente() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        Docente docenteActualizado = new Docente("Juan Perez", "1090275633", 20, "juan.perez@example.com", "333444555", "123new");
        bibliotecario.agregarDocente(docente);
        bibliotecario.actualizarDocente(docente.getIdentificacion(), docenteActualizado);
        assertTrue(biblioteca.getListUsuarios().contains(docenteActualizado));
        assertFalse(biblioteca.getListUsuarios().contains(docente));
    }

    @Test
    void testAgregarEstudiante() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Estudiante estudiante = new Estudiante("Jose", "29242432", 20, "jose@example.com", "81818181", "password123");
        bibliotecario.agregarEstudiante(estudiante);
        assertTrue(biblioteca.getListUsuarios().contains(estudiante));
    }

    @Test
    void testEliminarEstudiante() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Estudiante estudiante = new Estudiante("Jose", "29242432", 20, "jose@example.com", "81818181", "password123");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.eliminarEstudiante(estudiante.getIdentificacion());
        assertFalse(biblioteca.getListUsuarios().contains(estudiante));
    }

    @Test
    void testActualizarEstudiante() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Estudiante estudiante = new Estudiante("Jose", "29242432", 20, "jose@example.com", "81818181", "password123");
        Estudiante estudianteActualizado = new Estudiante("Jose Perez", "29242432", 22, "jose.perez@example.com", "12345678", "newpass");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.actualizarEstudiante(estudiante.getIdentificacion(), estudianteActualizado);
        assertTrue(biblioteca.getListUsuarios().contains(estudianteActualizado));
        assertFalse(biblioteca.getListUsuarios().contains(estudiante));
    }

    @Test
    void testAgregarVisitante() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Visitante visitante = new Visitante("Carlos", "39284955", 25, "carlos@example.com", "99887766","ajksai");
        bibliotecario.agregarVisitante(visitante);
        assertTrue(biblioteca.getListUsuarios().contains(visitante));
    }

    @Test
    void testEliminarVisitante() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Visitante visitante = new Visitante("Carlos", "39284955", 25, "carlos@example.com", "99887766","hyaud");
        bibliotecario.agregarVisitante(visitante);
        bibliotecario.eliminarVisitante(visitante.getIdentificacion());
        assertFalse(biblioteca.getListUsuarios().contains(visitante));
    }

    @Test
    void testActualizarVisitante() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Visitante visitante = new Visitante("Carlos", "39284955", 25, "carlos@example.com", "99887766","hoaJHO");
        Visitante visitanteActualizado = new Visitante("Carlos Gomez", "39284955", 26, "carlos.gomez@example.com", "12345678","akdjkajd");
        bibliotecario.agregarVisitante(visitante);
        bibliotecario.actualizarVisitante(visitante.getIdentificacion(), visitanteActualizado);
        assertTrue(biblioteca.getListUsuarios().contains(visitanteActualizado));
        assertFalse(biblioteca.getListUsuarios().contains(visitante));
    }
    @Test
    void testPrestamoExiste() {
        Biblioteca biblioteca = new Biblioteca("Uq");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        LibroDigital libroDigital = new LibroDigital("Matar a un ruiseñor", "Harper Lee", "Ficción", 1960, EstadoLibro.DISPONIBLE, "ebook123", FormatoLibro.PDF);
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaMax = LocalDate.now().plusDays(10);
        bibliotecario.agregarDocente(docente);
        bibliotecario.agregarLibroDigital(libroDigital);
        biblioteca.actualizarListaUsuarios();
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital.getTitulo(), fechaInicio, fechaMax);
        assertTrue(bibliotecario.prestamoExiste(docente.getIdentificacion(), libroDigital.getTitulo()));

    }
}