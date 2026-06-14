module org.example.lab1java2026vgtu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.lab1java2026vgtu to javafx.fxml;
    exports org.example.lab1java2026vgtu;
}