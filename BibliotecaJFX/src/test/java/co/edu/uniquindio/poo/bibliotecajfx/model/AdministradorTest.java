package co.edu.uniquindio.poo.bibliotecajfx.model;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class AdministradorTest {

    @Test
    void testAgregarBibliotecario() {
        Biblioteca biblioteca=new Biblioteca("UQ");
        Administrador administrador=new Administrador("Juan","12345",25,"<EMAIL>","81731873","juan091","A098",biblioteca);
        Bibliotecario bibliotecario= new Bibliotecario("Roberto","78901",45,"roberto@UQ","81731873","roberto091","B098",biblioteca);
        administrador.agregarBibliotecario(bibliotecario);
        assertEquals(1,biblioteca.getListEmpleados().size());
    }

    @Test
    void testEliminarBibliotecario() {
        Biblioteca biblioteca=new Biblioteca("UQ");
        Administrador administrador=new Administrador("Juan","12345",25,"<EMAIL>","81731873","juan091","A098",biblioteca);
        Bibliotecario bibliotecario= new Bibliotecario("Roberto","78901",45,"roberto@UQ","81731873","roberto091","B098",biblioteca);
        administrador.agregarBibliotecario(bibliotecario);
        administrador.eliminarBibliotecario(bibliotecario.getIdentificacion());
        assertEquals(0,biblioteca.getListEmpleados().size());
    }

    @Test
    void testActualizarBibliotecario() {
        Biblioteca biblioteca=new Biblioteca("UQ");
        Administrador administrador=new Administrador("Juan","12345",25,"<EMAIL>","81731873","juan091","A098",biblioteca);
        Bibliotecario bibliotecario= new Bibliotecario("Roberto","78901",45,"roberto@UQ","81731873","roberto091","B098",biblioteca);
        administrador.agregarBibliotecario(bibliotecario);
        Bibliotecario nuevoBibliotecario=new Bibliotecario("Carlos","74727",45,"carlos@UQ","81731873","Carloso091","B098",biblioteca);
        assertTrue(administrador.actualizarBibliotecario(bibliotecario.getIdentificacion(),nuevoBibliotecario));
    }

    @Test
    void testEnviarCodigoVerificacion() {
        Biblioteca biblioteca =new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan","12345",25,"<EMAIL>","81731873","juan091","A098",biblioteca);
        assertTrue(administrador.enviarCodigoVerificacion());
    }

    @Test
    void testVerificarCodigoVerificacion() {
        Biblioteca biblioteca =new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan","12345",25,"<EMAIL>","81731873","juan091","A098",biblioteca);
        administrador.enviarCodigoVerificacion();
        assertTrue(administrador.verificarCodigoVerificacion(administrador.getCodigoGenerado()));

    }

    @Test
    void testLibrosPrestadosEnMes() {
        Biblioteca biblioteca =new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan","12345",25,"<EMAIL>","81731873","juan091","A098",biblioteca);
        Bibliotecario bibliotecario= new Bibliotecario("Roberto","78901",45,"roberto@UQ","81731873","roberto091","B098",biblioteca);
        LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficcion", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
        LibroDigital libroDigital2 = new LibroDigital("El juego del ángel", "Carlos", "Drama", 2008, EstadoLibro.DISPONIBLE, "id2134asfg", FormatoLibro.EPUB);
        LibroFisico libroFisico = new LibroFisico("Don Quijote", "Cervantes", "Clasico", EstadoLibro.PRESTADO, 1605, 1000, "Editorial Clásica", "Estante 3A");
        Docente docente = new Docente("Juan", "1090275633", 16, "example@example.com", "81930139", "123");
        Estudiante estudiante = new Estudiante("Jose", "29242432", 16, "example@example.com", "81930139", "123");
        Estudiante estudiante1 = new Estudiante("Andres", "17219792", 26, "ahsjhsa@uq", "1973173", "juan891");
        bibliotecario.agregarLibroDigital(libroDigital1);
        bibliotecario.agregarLibroDigital(libroDigital2);
        bibliotecario.agregarLibroFisico(libroFisico);
        bibliotecario.agregarDocente(docente);
        bibliotecario.agregarEstudiante(estudiante);
        bibliotecario.agregarEstudiante(estudiante1);
        bibliotecario.realizarPrestamo(docente.getIdentificacion(), libroDigital1.getTitulo(), LocalDate.now().minusMonths(2),LocalDate.now().minusMonths(1));
        bibliotecario.realizarPrestamo(estudiante1.getIdentificacion(), libroDigital2.getTitulo(), LocalDate.now(),LocalDate.now());
        bibliotecario.realizarPrestamo(estudiante.getIdentificacion(), libroFisico.getTitulo(), LocalDate.now(),LocalDate.now());
        List<Libro> librosPrestadosEnMes= administrador.librosPrestadosEnMes(LocalDate.now().getMonthValue());
        assertEquals(2,librosPrestadosEnMes.size());
    }

    @Test
    void testUsuarioConMasPrestamosRealizados() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan", "12345", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        Bibliotecario bibliotecario = new Bibliotecario("Roberto", "78901", 45, "roberto@UQ", "81731873", "roberto091", "B098", biblioteca);

        Estudiante estudiante1 = new Estudiante("Jose", "29242432", 16, "example@example.com", "81930139", "123");
        Estudiante estudiante2 = new Estudiante("Andres", "17219792", 26, "ahsjhsa@uq", "1973173", "juan891");

        LibroDigital libro1 = new LibroDigital("Libro Digital 1", "andres", "suspenso", 2000, EstadoLibro.DISPONIBLE, "123PDF", FormatoLibro.PDF);
        LibroDigital libro2 = new LibroDigital("Libro Digital 2", "carlos", "ficcion", 2005, EstadoLibro.DISPONIBLE, "456PDF", FormatoLibro.PDF);

        bibliotecario.agregarEstudiante(estudiante1);
        bibliotecario.agregarEstudiante(estudiante2);
        bibliotecario.agregarLibroDigital(libro1);
        bibliotecario.agregarLibroDigital(libro2);

        bibliotecario.realizarPrestamo(estudiante1.getIdentificacion(), libro1.getTitulo(), LocalDate.now(), LocalDate.now());
        bibliotecario.realizarPrestamo(estudiante2.getIdentificacion(), libro2.getTitulo(), LocalDate.now(), LocalDate.now());
        bibliotecario.realizarDevolucion(estudiante1.getIdentificacion(), libro1.getTitulo());
        bibliotecario.realizarDevolucion(estudiante2.getIdentificacion(), libro2.getTitulo());


        bibliotecario.realizarPrestamo(estudiante1.getIdentificacion(), libro1.getTitulo(), LocalDate.now(), LocalDate.now());
        bibliotecario.realizarDevolucion(estudiante1.getIdentificacion(), libro1.getTitulo());
        List<Usuario> usuariosConMasPrestamos = administrador.usuarioConMasPrestamosRealizados();
        assertEquals(1, usuariosConMasPrestamos.size());
        assertTrue(usuariosConMasPrestamos.contains(estudiante1));
    }

    @Test
    void testLibrosSinPrestamos() {
        Biblioteca biblioteca = new Biblioteca("UQ");
        Administrador administrador = new Administrador("Juan", "12345", 25, "<EMAIL>", "81731873", "juan091", "A098", biblioteca);
        Bibliotecario bibliotecario = new Bibliotecario("Roberto", "78901", 45, "roberto@UQ", "81731873", "roberto091", "B098", biblioteca);
        Estudiante estudiante1 = new Estudiante("Jose", "29242432", 16, "example@example.com", "81930139", "123");
        Estudiante estudiante2 = new Estudiante("Andres", "17219792", 26, "ahsjhsa@uq", "1973173", "juan891");
        LibroDigital libro1 = new LibroDigital("Libro Digital 1", "andres", "suspenso", 2000, EstadoLibro.DISPONIBLE, "123PDF", FormatoLibro.PDF);
        LibroDigital libro2 = new LibroDigital("Libro Digital 2", "carlos", "ficcion", 2005, EstadoLibro.DISPONIBLE, "456PDF", FormatoLibro.PDF);
        bibliotecario.agregarEstudiante(estudiante1);
        bibliotecario.agregarEstudiante(estudiante2);
        bibliotecario.agregarLibroDigital(libro1);
        bibliotecario.agregarLibroDigital(libro2);
        bibliotecario.realizarPrestamo(estudiante1.getIdentificacion(), libro1.getTitulo(), LocalDate.now(), LocalDate.now());
        bibliotecario.realizarDevolucion(estudiante1.getIdentificacion(), libro1.getTitulo());
        List<Libro> librosSinPrestamos = administrador.librosSinPrestamos();
        assertEquals(1, librosSinPrestamos.size());
        assertTrue(librosSinPrestamos.contains(libro2));
    }
}