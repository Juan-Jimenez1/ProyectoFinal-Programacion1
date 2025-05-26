package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void estaDisponible() {
        Libro libro = new Libro("La sombra del viento", "Juan", "Ficción", 2010);
        assertTrue(libro.estaDisponible());
    }
}