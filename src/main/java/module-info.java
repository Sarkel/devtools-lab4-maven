module pl.edu.wszib.student.kubalski.lab6_maven {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;


    opens pl.edu.wszib.student.kubalski.lab6_maven to javafx.fxml;
    exports pl.edu.wszib.student.kubalski.lab6_maven;
}