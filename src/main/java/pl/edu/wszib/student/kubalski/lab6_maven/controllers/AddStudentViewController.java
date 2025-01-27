package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.fxml.FXML;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;

@Component
@RequiredArgsConstructor
public class AddStudentViewController {
    private final RouteService routeService;

    private Long schoolClassId;

    @FXML
    public void initialize() {
        schoolClassId = routeService.getParams();
    }

    @FXML
    public void save() {
        routeService.switchScene(Route.SCHOOL_CLASS_DETAILS, schoolClassId);
    }

    @FXML
    public void cancel() {
        routeService.switchScene(Route.SCHOOL_CLASS_DETAILS, schoolClassId);
    }
}
