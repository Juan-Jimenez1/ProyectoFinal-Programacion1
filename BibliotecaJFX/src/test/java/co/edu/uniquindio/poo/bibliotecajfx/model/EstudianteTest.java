package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    @Test
    void testPuedePrestar() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroFisico libroFisico=new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.DISPONIBLE, 1605, 1000, "Editorial Clásica", "Estante 3A");
        LibroDigital libroDigital2 = new LibroDigital("El juego del ángel", "Carlos", "Drama", 2008, EstadoLibro.DISPONIBLE, "id2134asfg", FormatoLibro.EPUB);
        LibroFisico libroFisico1 =new LibroFisico("asjdaj", "asjdaj", "asjdaj", EstadoLibro.DISPONIBLE, 1605, 1000, "asjdaj", "asjdaj");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarLibroDigital(libroDigital2);
        bibliotecario.agregarLibroFisico(libroFisico1);
        bibliotecario.realizarPrestamo(estudiante.getIdentificacion(), libroDigital1.getTitulo(), LocalDate.now(), LocalDate.now().plusMonths(1));
        assertFalse(estudiante.puedePrestar());
    }

    @Test
    void testCantidadLibrosPrestados() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.realizarPrestamo(estudiante.getIdentificacion(), libroDigital1.getTitulo(), LocalDate.now(), LocalDate.now().plusMonths(1));
        assertEquals(1,estudiante.cantidadLibrosPrestados());
    }

    @Test
    void testLibroDevuelto() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroFisico libroFisico=new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.DISPONIBLE, 1605, 1000, "Editorial Clásica", "Estante 3A");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo=new Prestamo(LocalDate.now(),LocalDate.now(),libroDigital1,estudiante);
        Prestamo prestamo1=new Prestamo(LocalDate.now(),LocalDate.now(),libroFisico,estudiante);
        estudiante.agregarPrestamo(prestamo);
        estudiante.agregarPrestamo(prestamo1);
        assertEquals(2,estudiante.getListPrestamosEstudiante().size());
    }

    @Test
    void testAgregarPrestamo() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroFisico libroFisico=new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.DISPONIBLE, 1605, 1000, "Editorial Clásica", "Estante 3A");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo=new Prestamo(LocalDate.now(),LocalDate.now(),libroDigital1,estudiante);
        Prestamo prestamo1=new Prestamo(LocalDate.now(),LocalDate.now(),libroFisico,estudiante);
        estudiante.agregarPrestamo(prestamo);
        estudiante.agregarPrestamo(prestamo1);
        estudiante.libroDevuelto(prestamo);
        assertEquals(1,estudiante.getListPrestamosEstudiante().size());
    }
}