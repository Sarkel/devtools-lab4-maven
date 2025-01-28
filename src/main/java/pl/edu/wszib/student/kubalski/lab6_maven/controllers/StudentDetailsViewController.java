package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.StudentService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentDTO;

@Component
@RequiredArgsConstructor
public class StudentDetailsViewController {
    private final RouteService routeService;
    private final StudentService studentService;

    private Long studentId;
    private StudentDTO student;

    @FXML
    private Text titleText;

    @FXML
    public void initialize() {
        studentId = routeService.getParams();

        studentService.findById(studentId).ifPresentOrElse(s -> {
            student = s;
            titleText.setText("Student details for " + student.getFirstName() + " " + student.getLastName());
        }, () -> titleText.setText("Not found"));
    }

    @FXML
    public void goBack() {
        routeService.switchScene(Route.SCHOOL_CLASS_DETAILS, student.getSchoolClassId());
    }

    @FXML
    public void addGrade() {
        routeService.switchScene(Route.ADD_STUDENT_GRADE, studentId);
    }
}
