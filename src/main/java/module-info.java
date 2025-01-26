module pl.edu.wszib.student.kubalski.lab6_maven {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires org.hibernate.orm.core;
    requires spring.beans;

    opens pl.edu.wszib.student.kubalski.lab6_maven to javafx.fxml;
    opens pl.edu.wszib.student.kubalski.lab6_maven.entities to org.hibernate.orm.core, spring.core, spring.beans, spring.data.jpa, UNNAMED;
    opens pl.edu.wszib.student.kubalski.lab6_maven.repositories to org.hibernate.orm.core, spring.core, spring.beans, spring.data.jpa, UNNAMED;

    exports pl.edu.wszib.student.kubalski.lab6_maven;
}
