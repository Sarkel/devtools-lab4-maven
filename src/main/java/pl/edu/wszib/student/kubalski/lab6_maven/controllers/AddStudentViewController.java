package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.SchoolClassService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.StudentService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.NewStudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.util.DmlResult;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class AddStudentViewController {
    private final RouteService routeService;
    private final StudentService studentService;
    private final SchoolClassService schoolClassService;

    private Long schoolClassId;

    @FXML
    private Text titleText;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Label firstNameErrorLabel;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private Label lastNameErrorLabel;

    @FXML
    public void initialize() {
        schoolClassId = routeService.getParams();

        schoolClassService.findById(schoolClassId)
                .ifPresentOrElse(sc -> {
                    titleText.setText("Add student to " + sc.getName());
                }, System.err::println);
    }

    @FXML
    public void save() {
        NewStudentDTO newStudentDTO = NewStudentDTO.builder()
                .firstName(firstNameTextField.getText())
                .lastName(lastNameTextField.getText())
                .schoolClassId(schoolClassId)
                .build();

        DmlResult dmlResult = studentService.create(newStudentDTO);

        if (dmlResult.hasErrors()) {
            dmlResult.getErrors().forEach((fieldName, errors) -> {
                String errorMessage = String.join(", ", errors);

                switch (fieldName) {
                    case "fistName":
                        firstNameErrorLabel.setText(errorMessage);
                        firstNameErrorLabel.setVisible(true);
                        break;
                    case "lastName":
                        lastNameErrorLabel.setText(errorMessage);
                        lastNameErrorLabel.setVisible(true);
                        break;
                    default:
                        // Handle unknown fields
                        System.err.println("Unhandled field: " + fieldName + " has errors: " + errors);
                }
            });
        } else {
            routeService.switchScene(Route.SCHOOL_CLASS_DETAILS, schoolClassId);
        }
    }

    @FXML
    public void cancel() {
        routeService.switchScene(Route.SCHOOL_CLASS_DETAILS, schoolClassId);
    }
}
