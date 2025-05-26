package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibroDigitalTest {

    @Test
    void testPrestar() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        bibliotecario.agregarLibroDigital(libroDigital1);
        libroDigital1.prestar();
        assertEquals(EstadoLibro.PRESTADO, libroDigital1.getEstado());
    }

    @Test
    void testDevolver() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Bibliotecario bibliotecario = new Bibliotecario("John Doe", "12345", 30, "john@example.com", "1234567890", "cred123", "B091", biblioteca);
        Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficción", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarDocente(docente);
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital1.getTitulo(), LocalDate.now(), LocalDate.now().plusMonths(1));
        libroDigital1.devolver();
        assertEquals(EstadoLibro.DISPONIBLE, libroDigital1.getEstado());

    }
}