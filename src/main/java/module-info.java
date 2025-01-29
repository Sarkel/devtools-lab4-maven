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
    requires static lombok;
    requires jakarta.annotation;
    requires jakarta.validation;
    requires java.desktop;
    requires spring.data.commons;
    requires org.mapstruct;

    opens pl.edu.wszib.student.kubalski.lab6_maven;
    opens pl.edu.wszib.student.kubalski.lab6_maven.entities;
    opens pl.edu.wszib.student.kubalski.lab6_maven.repositories;
    opens pl.edu.wszib.student.kubalski.lab6_maven.controllers;
    opens pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass;
    opens pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto;
    opens pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student;
    opens pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto;
    opens pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade;
    opens pl.edu.wszib.student.kubalski.lab6_maven.services.config;
    opens db.migration;
    opens pl.edu.wszib.student.kubalski.lab6_maven.routing;
    opens pl.edu.wszib.student.kubalski.lab6_maven.util;

    exports pl.edu.wszib.student.kubalski.lab6_maven;
    exports pl.edu.wszib.student.kubalski.lab6_maven.controllers;
    exports pl.edu.wszib.student.kubalski.lab6_maven.entities;
    exports pl.edu.wszib.student.kubalski.lab6_maven.repositories;
    exports pl.edu.wszib.student.kubalski.lab6_maven.services.config;
    exports pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass;
    exports pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto;
    exports pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student;
    exports pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto;
    exports pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade;
    exports pl.edu.wszib.student.kubalski.lab6_maven.routing;
    exports pl.edu.wszib.student.kubalski.lab6_maven.util;
}
