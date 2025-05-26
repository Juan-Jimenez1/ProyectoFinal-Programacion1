module co.edu.uniquindio.poo.bibliotecajfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports co.edu.uniquindio.poo.bibliotecajfx.controller;
    exports co.edu.uniquindio.poo.bibliotecajfx.model;
    exports co.edu.uniquindio.poo.bibliotecajfx.viewController;
    exports co.edu.uniquindio.poo.bibliotecajfx;

    opens co.edu.uniquindio.poo.bibliotecajfx.controller to javafx.fxml;
    opens co.edu.uniquindio.poo.bibliotecajfx.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.bibliotecajfx to javafx.fxml, javafx.graphics;
}