package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibroFisicoTest {

    @Test
    void testPrestar() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroFisico libroFisico= new LibroFisico("La sombra del viento", "Juan", "Ficción",EstadoLibro.DISPONIBLE,2000,600,"Los Tres Editores","estanteria A3");
        bibliotecario.agregarLibroFisico(libroFisico);
        libroFisico.prestar();
        assertEquals(EstadoLibro.PRESTADO, libroFisico.getEstado());
    }

    @Test
    void testDevolver() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroFisico libroFisico= new LibroFisico("La sombra del viento", "Juan", "Ficción",EstadoLibro.DISPONIBLE,2000,600,"Los Tres Editores","estanteria A3");
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarDocente(docente);
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroFisico.getTitulo(), LocalDate.now(), LocalDate.now().plusMonths(1));
        libroFisico.devolver();
        assertEquals(EstadoLibro.DISPONIBLE, libroFisico.getEstado());

    }
}