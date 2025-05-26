package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.controller.VerificarCodigoAdministradorController;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;


import java.net.URL;
import java.util.ResourceBundle;

public class VerificarCodigoAdministradorViewController  {
    VerificarCodigoAdministradorController verificarCodigoAdministradorController;
    App app;
    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

   @FXML
   private TextField textFieldCodigo;

   @FXML
   private Button btnVerificarCodigo;

   @FXML
   private Button btnEnviarCodigo;




    @FXML
    void onVerificarCodigo() {
       int codigo = Integer.parseInt(textFieldCodigo.getText());

        if(verificarCodigoAdministradorController.verificarCodigo(codigo)){
            app.openCrudAdministrador();
        }else{
            app.openCrudInicioSesionAdministrador();
        }
    }
    @FXML
    void onEnviarCodigo() {
        verificarCodigoAdministradorController.enviarCodigoVerificacion();
    }
    public void setApp(App app) {
        this.app = app;
        verificarCodigoAdministradorController = new VerificarCodigoAdministradorController(App.administrador);
    }

}
