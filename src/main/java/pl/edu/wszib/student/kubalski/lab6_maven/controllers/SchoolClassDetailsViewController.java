package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.SchoolClassService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentWithAverageGradeDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.StudentService;

import java.util.List;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class SchoolClassDetailsViewController {
    private final RouteService routeService;
    private final StudentService studentService;
    private final SchoolClassService schoolClassService;

    private Long schoolClassId;

    @FXML
    private TableView<StudentWithAverageGradeDTO> studentsTableView;

    private final ObservableList<StudentWithAverageGradeDTO> items = FXCollections.observableArrayList();

    @FXML
    private Text titleText;

    @FXML
    private Text teacherNameText;

    @FXML
    private Text gradeLevelText;

    @FXML
    private Text schoolYearText;

    @FXML
    private void initialize() {
        this.schoolClassId = routeService.getParams();

        schoolClassService.findById(this.schoolClassId).ifPresentOrElse(
                schoolClass -> {
                    titleText.setText("School class details for " + schoolClass.getName());
                    teacherNameText.setText("Teacher name: " + schoolClass.getTeacherName());
                    gradeLevelText.setText("Grade level: " + schoolClass.getGradeLevel());
                    schoolYearText.setText("School year: " + schoolClass.getSchoolYear());
                },
                () -> titleText.setText("Not found")
        );

        TableColumn<StudentWithAverageGradeDTO, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        studentsTableView.getColumns().add(firstNameColumn);

        TableColumn<StudentWithAverageGradeDTO, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentsTableView.getColumns().add(lastNameColumn);

        TableColumn<StudentWithAverageGradeDTO, String> gradeLevelColumn = new TableColumn<>("Average Grade");
        gradeLevelColumn.setCellValueFactory(new PropertyValueFactory<>("averageGrade"));
        studentsTableView.getColumns().add(gradeLevelColumn);

        List<StudentWithAverageGradeDTO> students = studentService.findBySchoolClassId(schoolClassId);
        items.addAll(students);
        studentsTableView.setItems(items);
    }

    @FXML
    private void goBack() {
        routeService.switchScene(Route.SCHOOL_CLASS_LIST);
    }

    @FXML
    private void goToStudentDetails() {
        StudentWithAverageGradeDTO selectedStudent = studentsTableView.getSelectionModel().getSelectedItem();
        routeService.switchScene(Route.STUDENT_DETAILS, selectedStudent.getId());
    }

    @FXML
    private void addStudent() {
        routeService.switchScene(Route.ADD_STUDENT, schoolClassId);
    }
}
