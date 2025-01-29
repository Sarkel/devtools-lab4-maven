package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.StudentService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.StudentGradeService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto.StudentGradeDTO;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDetailsViewController {
    private final RouteService routeService;
    private final StudentService studentService;
    private final StudentGradeService studentGradeService;

    private Long studentId;
    private StudentDTO student;

    @FXML
    private TableView<StudentGradeDTO> studentGradesTableView;

    private final ObservableList<StudentGradeDTO> items = FXCollections.observableArrayList();

    @FXML
    private Text titleText;

    @FXML
    public void initialize() {
        studentId = routeService.getParams();

        studentService.findById(studentId).ifPresentOrElse(s -> {
            student = s;
            titleText.setText("Student details for " + student.getFirstName() + " " + student.getLastName());
        }, () -> titleText.setText("Not found"));

        TableColumn<StudentGradeDTO, LocalDate> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        studentGradesTableView.getColumns().add(dateColumn);

        TableColumn<StudentGradeDTO, Integer> gradeColumn = new TableColumn<>("Grade");
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        gradeColumn.setCellFactory(column -> new StudentGradeCell());
        studentGradesTableView.getColumns().add(gradeColumn);

        List<StudentGradeDTO> studentGrades = studentGradeService.findStudentGradesByStudentId(studentId);
        items.addAll(studentGrades);
        studentGradesTableView.setItems(items);
    }

    @FXML
    private void goBack() {
        routeService.switchScene(Route.SCHOOL_CLASS_DETAILS, student.getSchoolClassId());
    }

    @FXML
    private void addGrade() {
        routeService.switchScene(Route.ADD_STUDENT_GRADE, studentId);
    }

    private static class StudentGradeCell extends TableCell<StudentGradeDTO, Integer> {
        @Override
        protected void updateItem(Integer grade, boolean empty) {
            super.updateItem(grade, empty);

            if (empty || grade == null) {
                this.setText(null);
                this.setStyle("");
                return;
            }
            this.setText(String.valueOf(grade));

            StudentGradeDTO studentGrade = this.getTableRow().getItem();

            if (studentGrade != null) {
                switch (studentGrade.getWeight()) {
                    case 2:
                        this.setStyle("-fx-text-fill: #ff0000");
                        break;
                    case 3:
                        this.setStyle("-fx-font-weight: bold; -fx-text-fill: #ff0000");
                        break;
                    default:
                        this.setStyle("");
                }
            }
        }
    }

}
