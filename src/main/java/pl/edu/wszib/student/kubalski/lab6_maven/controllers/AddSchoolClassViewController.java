package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.NewSchoolClassDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.SchoolClassService;
import pl.edu.wszib.student.kubalski.lab6_maven.util.DmlResult;

@Component
@RequiredArgsConstructor
@Scope("prototype")
// todo: refactor to use JavaFX bindings
public class AddSchoolClassViewController {
    private final RouteService routeService;
    private final SchoolClassService schoolClassService;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label nameErrorLabel;

    @FXML
    private TextField teacherNameTextField;

    @FXML
    private Label teacherNameErrorLabel;

    @FXML
    private TextField gradeLevelTextField;

    @FXML
    private Label gradeLevelErrorLabel;

    @FXML
    public void cancel() {
        routeService.switchScene(Route.SCHOOL_CLASS_LIST);
    }

    @FXML
    public void save() {
        NewSchoolClassDTO newSchoolClassDTO = NewSchoolClassDTO.builder()
                .name(nameTextField.getText())
                .teacherName(teacherNameTextField.getText())
                .gradeLevel(gradeLevelTextField.getText())
                .build();

        DmlResult dmlResult = schoolClassService.create(newSchoolClassDTO);

        if (dmlResult.hasErrors()) {
            dmlResult.getErrors().forEach((fieldName, errors) -> {
                String errorMessage = String.join(", ", errors);

                switch (fieldName) {
                    case "name":
                        nameErrorLabel.setText(errorMessage);
                        nameErrorLabel.setVisible(true);
                        break;
                    case "teacherName":
                        teacherNameErrorLabel.setText(errorMessage);
                        teacherNameErrorLabel.setVisible(true);
                        break;
                    case "gradeLevel":
                        gradeLevelErrorLabel.setText(errorMessage);
                        gradeLevelErrorLabel.setVisible(true);
                        break;
                    default:
                        // Handle unknown fields
                        System.err.println("Unhandled field: " + fieldName + " has errors: " + errors);
                }
            });
        } else {
            routeService.switchScene(Route.SCHOOL_CLASS_LIST);
        }
    }
}
