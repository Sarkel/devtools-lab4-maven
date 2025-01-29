package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.StudentService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.StudentGradeService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto.NewStudentGradeDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.util.DmlResult;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class AddStudentGradeViewController {
    private final RouteService routeService;
    private final StudentService studentService;
    private final StudentGradeService studentGradeService;

    private StudentDTO student;

    @FXML
    private TextField gradeTextField;

    @FXML
    private Label gradeErrorLabel;

    @FXML
    private TextField weightTextField;

    @FXML
    private Label weightErrorLabel;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private Label dateErrorLabel;

    @FXML
    private void initialize() {
        Long studentId = routeService.getParams();

        student = studentService.findById(studentId).orElseThrow();
    }

    @FXML
    private void save() {
        NewStudentGradeDTO newStudentGrade = NewStudentGradeDTO.builder()
                .studentId(student.getId())
                .grade(gradeTextField.getText())
                .date(dateDatePicker.getValue())
                .weight(weightTextField.getText())
                .schoolClassId(student.getSchoolClassId())
                .build();

        DmlResult dmlResult = studentGradeService.create(newStudentGrade);

        if (dmlResult.hasErrors()) {
            dmlResult.getErrors().forEach((fieldName, errors) -> {
                String errorMessage = String.join(", ", errors);

                switch (fieldName) {
                    case "grade":
                        gradeErrorLabel.setText(errorMessage);
                        gradeErrorLabel.setVisible(true);
                        break;
                    case "date":
                        dateErrorLabel.setText(errorMessage);
                        dateErrorLabel.setVisible(true);
                        break;
                    case "weight":
                        weightErrorLabel.setText(errorMessage);
                        weightErrorLabel.setVisible(true);
                        break;
                    default:
                        // Handle unknown fields
                        System.err.println("Unhandled field: " + fieldName + " has errors: " + errors);
                }
            });
        } else {
            routeService.switchScene(Route.STUDENT_DETAILS, student.getId());
        }
    }

    @FXML
    private void cancel() {
        routeService.switchScene(Route.STUDENT_DETAILS, student.getId());
    }
}
