package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DocenteTest {

    @Test
    void testPuedePrestar() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroFisico libroFisico=new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.DISPONIBLE, 1605, 1000, "Editorial Clásica", "Estante 3A");
        LibroDigital libroDigital2 = new LibroDigital("El juego del ángel", "Carlos", "Drama", 2008, EstadoLibro.DISPONIBLE, "id2134asfg", FormatoLibro.EPUB);
        LibroFisico libroFisico1 =new LibroFisico("asjdaj", "asjdaj", "asjdaj", EstadoLibro.DISPONIBLE, 1605, 1000, "asjdaj", "asjdaj");
        bibliotecario.agregarDocente(docente);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarLibroDigital(libroDigital2);
        bibliotecario.agregarLibroFisico(libroFisico1);
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital1.getTitulo(), LocalDate.now(), LocalDate.now().plusMonths(1));
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital2.getTitulo(), LocalDate.now(), LocalDate.now().plusMonths(1));
        assertTrue(docente.puedePrestar());
    }

    @Test
    void atestCantidadLibrosPrestados() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroFisico libroFisico=new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.DISPONIBLE, 1605, 1000, "Editorial Clásica", "Estante 3A");
        LibroDigital libroDigital2 = new LibroDigital("El juego del ángel", "Carlos", "Drama", 2008, EstadoLibro.DISPONIBLE, "id2134asfg", FormatoLibro.EPUB);
        LibroFisico libroFisico1 =new LibroFisico("asjdaj", "asjdaj", "asjdaj", EstadoLibro.DISPONIBLE, 1605, 1000, "asjdaj", "asjdaj");
        bibliotecario.agregarDocente(docente);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarLibroDigital(libroDigital2);
        bibliotecario.agregarLibroFisico(libroFisico1);
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital1.getTitulo(), LocalDate.now(), LocalDate.now().plusMonths(1));
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital2.getTitulo(), LocalDate.now(), LocalDate.now().plusMonths(1));
       assertEquals(2,docente.cantidadLibrosPrestados());
    }

    @Test
    void testAgregarPrestamo() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroFisico libroFisico=new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.DISPONIBLE, 1605, 1000, "Editorial Clásica", "Estante 3A");
        bibliotecario.agregarDocente(docente);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo=new Prestamo(LocalDate.now(),LocalDate.now(),libroDigital1,docente);
        Prestamo prestamo1=new Prestamo(LocalDate.now(),LocalDate.now(),libroFisico,docente);
        docente.agregarPrestamo(prestamo);
        docente.agregarPrestamo(prestamo1);
        assertEquals(2,docente.getListPrestamosDocentes().size());

    }

    @Test
    void testLibroDevuelto() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroFisico libroFisico=new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.DISPONIBLE, 1605, 1000, "Editorial Clásica", "Estante 3A");
        bibliotecario.agregarDocente(docente);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo=new Prestamo(LocalDate.now(),LocalDate.now(),libroDigital1,docente);
        Prestamo prestamo1=new Prestamo(LocalDate.now(),LocalDate.now(),libroFisico,docente);
        docente.agregarPrestamo(prestamo);
        docente.agregarPrestamo(prestamo1);
        docente.libroDevuelto(prestamo);
        assertEquals(1,docente.getListPrestamosDocentes().size());
    }
}