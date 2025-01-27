package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class SchoolClassDetailsViewController {
    private final RouteService routeService;

    private Long schoolClassId;

    @FXML
    public Text titleText;

    @FXML
    public void initialize() {
        this.schoolClassId = routeService.getParams();
        titleText.setText("School class details for " + schoolClassId);
    }

    @FXML
    public void goBack() {
        routeService.switchScene(Route.SCHOOL_CLASS_LIST);
    }
}
