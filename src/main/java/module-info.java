module org.ex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.ex to javafx.fxml;
    exports org.ex;
}