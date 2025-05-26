package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoTest {

    @Test
    void devolverLibro() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico= new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo= new Prestamo(LocalDate.now().minusDays(2),LocalDate.now(),libroFisico,estudiante);
        bibliotecario.realizarPrestamo(prestamo.getUsuario().getIdentificacion(),prestamo.getLibro().getTitulo(),prestamo.getFechaPrestamo(),prestamo.getFechaLimite());
        prestamo.devolverLibro();
        assertTrue(prestamo.getDevuelto());
    }

    @Test
    void testPrestarLibro() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico= new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo= new Prestamo(LocalDate.now(),LocalDate.now(),libroFisico,estudiante);
        prestamo.prestarLibro();
        assertEquals(EstadoLibro.PRESTADO,prestamo.getLibro().getEstado());
    }

    @Test
    void testCalcularValorPrestamo() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico= new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo= new Prestamo(LocalDate.now().minusMonths(1),LocalDate.now().minusDays(15),libroFisico,estudiante);
        prestamo.setFechaDevolucion(LocalDate.now());
        assertEquals(225000,prestamo.calcularValorPrestamo());

    }

    @Test
    void testEstaVencido() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico= new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo= new Prestamo(LocalDate.now().minusMonths(1),LocalDate.now().minusDays(15),libroFisico,estudiante);
        assertTrue(prestamo.estaVencido());
    }

    @Test
    void testEstaPrestado() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico= new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        Estudiante estudiante= new Estudiante("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarLibroFisico(libroFisico);
        Prestamo prestamo= new Prestamo(LocalDate.now().minusMonths(1),LocalDate.now().minusDays(15),libroFisico,estudiante);
        bibliotecario.realizarPrestamo(prestamo.getUsuario().getIdentificacion(),prestamo.getLibro().getTitulo(),prestamo.getFechaPrestamo(),prestamo.getFechaLimite());
        assertTrue(prestamo.estaPrestado());
    }
}