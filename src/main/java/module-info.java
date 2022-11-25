
    module ru.moonshine1l.weather {


    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.json;
        requires java.logging;

        opens ru.moonshine1l.weather to javafx.fxml;
    exports ru.moonshine1l.weather;
}
