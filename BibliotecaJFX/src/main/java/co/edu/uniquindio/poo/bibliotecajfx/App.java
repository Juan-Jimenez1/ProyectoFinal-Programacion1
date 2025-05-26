package co.edu.uniquindio.poo.bibliotecajfx;

import co.edu.uniquindio.poo.bibliotecajfx.controller.MostrarLibrosDocenteController;
import co.edu.uniquindio.poo.bibliotecajfx.model.*;
import co.edu.uniquindio.poo.bibliotecajfx.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class App extends Application {
    private Stage primaryStage;
    public static  Biblioteca biblioteca= new Biblioteca("UQ");
    public static  Bibliotecario bibliotecario= new Bibliotecario("Juan","1234",15,"jj@correo.com","3117173931","Abc102","B091",biblioteca);
    public static  Administrador administrador= new Administrador("Carlos","1838182",38,"carlos@uqvirtual","21728127","Carlos123","Adm001",biblioteca);
    public static  LibroDigital libroDigital1 = new LibroDigital("La sombra del viento", "Juan", "Ficcion", 2010, EstadoLibro.DISPONIBLE, "hdsdwiyd8wu", FormatoLibro.PDF);
    public static  LibroDigital libroDigital2 = new LibroDigital("El juego del ángel", "Carlos", "Drama", 2008, EstadoLibro.DISPONIBLE, "id2134asfg", FormatoLibro.EPUB);
    public static  LibroFisico libroFisico = new LibroFisico("Don Quijote", "Cervantes", "Clasico",EstadoLibro.PRESTADO ,1605, 1000, "Editorial Clásica", "Estante 3A");
    public static LibroReferencia libroReferencia = new LibroReferencia("Enciclopedia Británica", "Varios Autores", "Referencia", EstadoLibro.REFERENCIA,2010);
    public static Estudiante estudiante = new Estudiante("Jose", "29242432", 16, "example@example.com", "81930139", "123");
    public static Docente docente= new Docente("Juan", "8492428", 20, "<EMAIL>", "962601234", "123456");
    @Override
   public void start(Stage primaryStage) throws IOException {
       this.primaryStage = primaryStage;
       this.primaryStage.setTitle("Biblioteca UQ");
       openViewPrincipal();

   }

    private void openViewPrincipal() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Primary.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            primaryViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       biblioteca.agregarAdministrador(administrador);
       administrador.agregarBibliotecario(bibliotecario);
       bibliotecario.agregarLibroDigital(libroDigital1);
       bibliotecario.agregarLibroDigital(libroDigital2);
       bibliotecario.agregarLibroFisico(libroFisico);
       bibliotecario.agregarLibroReferencia(libroReferencia);
       bibliotecario.agregarEstudiante(estudiante);
       bibliotecario.agregarDocente(docente);
       bibliotecario.realizarPrestamo(estudiante.getIdentificacion(),libroDigital1.getTitulo(),LocalDate.now(),LocalDate.now());
       bibliotecario.realizarPrestamo(docente.getIdentificacion(),libroDigital2.getTitulo(),LocalDate.now(),LocalDate.now());
      launch();
    }
    public void openCrudPrimary() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("Primary.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            primaryViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudSeleccionGrupoUsuario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudSeleccionGrupoUsuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            SeleccionGrupoUsuarioViewController seleccionGrupoUsuarioViewController = loader.getController();
            seleccionGrupoUsuarioViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudSeleccionUsuario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudSeleccionUsuario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            SeleccionUsuarioViewController seleccionUsuarioViewController = loader.getController();
            seleccionUsuarioViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudSeleccionEmpleado() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudSeleccionEmpleado.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            SeleccionEmpleadoViewController seleccionEmpleadoViewController = loader.getController();
            seleccionEmpleadoViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudInicioSesionAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudInicioSesionAdministrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            InicioSesionAdministradorViewController inicioSesionAdministradorViewController = loader.getController();
            inicioSesionAdministradorViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudInicioSesionBibliotecario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudInicioSesionBibliotecario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            InicioSesionBibliotecarioViewController inicioSesionBibliotecarioViewController = loader.getController();
            inicioSesionBibliotecarioViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudInicioSesionDocente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudInicioSesionDocente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            InicioSesionDocenteViewController inicioSesionDocenteViewController = loader.getController();
            inicioSesionDocenteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudInicioSesionEstudiante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudInicioSesionEstudiante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            InicioSesionEstudianteViewController inicioSesionEstudianteViewController = loader.getController();
            inicioSesionEstudianteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudInicioSesionVisitante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudInicioSesionVisitante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            InicioSesionVisitanteViewController inicioSesionVisitanteViewController = loader.getController();
            inicioSesionVisitanteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudVerificarCodigoAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudVerificarCodigoAdministrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            VerificarCodigoAdministradorViewController verificarCodigoAdministradorViewController = loader.getController();
            verificarCodigoAdministradorViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudGestionarLibrosFisicos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudGestionLibroFisico.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionLibroFisicoViewController gestionLibroFisicoViewController= loader.getController();
            gestionLibroFisicoViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudGestionarLibrosDigitales() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudGestionLibroDigital.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionLibroDigitalViewController gestionLibroDigitalViewController= loader.getController();
            gestionLibroDigitalViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudGestionarLibrosReferencia() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudGestionLibroReferencia.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionLibroReferenciaViewController gestionLibroReferenciaViewController = loader.getController();
            gestionLibroReferenciaViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudBibliotecario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudBibliotecario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            BibliotecarioViewController bibliotecarioViewController = loader.getController();
            bibliotecarioViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudAdministrador.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            AdministradorViewController administradorViewController = loader.getController();
            administradorViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudGestionBibliotecario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudGestionBibliotecario.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionBibiotecarioViewController gestionBibiotecarioViewController = loader.getController();
            gestionBibiotecarioViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudGestionEstudiante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudGestionEstudiante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionEstudianteViewController gestionEstudianteViewController = loader.getController();
            gestionEstudianteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudGestionDocente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudGestionDocente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionDocenteViewController gestionDocenteViewController = loader.getController();
            gestionDocenteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudGestionVisitante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudGestionVisitante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionVisitanteViewController gestionVisitanteViewController = loader.getController();
            gestionVisitanteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudEstudiante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudEstudiante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            EstudianteViewController estudianteViewController = loader.getController();
            estudianteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudDocente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudDocente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            DocenteViewController docenteViewController = loader.getController();
            docenteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudVisitante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudVisitante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            VisitanteViewController visitanteViewController = loader.getController();
            visitanteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudHistorialPrestamosEstudiante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudHistorialPrestamosEstudiante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HistorialPrestamosEstudianteViewController historialPrestamosEstudianteViewController = loader.getController();
            historialPrestamosEstudianteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudHistorialPrestamosDocente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudHistorialPrestamosDocente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            HistorialPrestamosDocenteViewController historialPrestamosDocenteViewController= loader.getController();
            historialPrestamosDocenteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudMostrarLibrosEstudiante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudMostrarLibrosEstudiante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MostrarLibrosEstudianteViewController mostrarLibrosEstudianteViewController= loader.getController();
            mostrarLibrosEstudianteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudMostrarLibrosDocente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudMostrarLibrosDocente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MostrarLibrosDocenteViewController mostrarLibrosDocenteViewController = loader.getController();
            mostrarLibrosDocenteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudMostrarLibrosVisitante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudMostrarLibrosVisitante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MostrarLibrosVisitanteViewController mostrarLibrosVisitanteViewController = loader.getController();
            mostrarLibrosVisitanteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudMostrarPrestamosActivosEstudiante() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudMostrarPrestamosActivosEstudiante.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MostrarPrestamosActivosEstudianteViewController mostrarPrestamosActivosEstudianteViewController = loader.getController();
            mostrarPrestamosActivosEstudianteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudMostrarPrestamosActivosDocente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudMostrarPrestamosActivosDocente.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MostrarPrestamosActivosDocenteViewController mostrarPrestamosActivosDocenteViewController= loader.getController();
            mostrarPrestamosActivosDocenteViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudUsuarioConMasPrestamos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudUsuarioConMasPrestamos.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            UsuarioConMasPrestamosViewController usuarioConMasPrestamosViewController= loader.getController();
            usuarioConMasPrestamosViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void openCrudLibrosSinPrestamos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("CrudLibrosSinPrestamos.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LibrosSinPrestamosViewController librosSinPrestamosViewController= loader.getController();
            librosSinPrestamosViewController.setApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




}