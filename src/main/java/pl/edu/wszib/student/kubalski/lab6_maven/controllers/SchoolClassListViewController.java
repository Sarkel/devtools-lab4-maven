package pl.edu.wszib.student.kubalski.lab6_maven.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.Route;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.SchoolClassService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.SchoolClassWithStudentCountDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class SchoolClassListViewController {

    private final SchoolClassService schoolClassService;

    private final RouteService routeService;

    @FXML
    private TableView<SchoolClassWithStudentCountDTO> schoolClassTableView;

    private final ObservableList<SchoolClassWithStudentCountDTO> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        TableColumn<SchoolClassWithStudentCountDTO, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        schoolClassTableView.getColumns().add(nameColumn);

        TableColumn<SchoolClassWithStudentCountDTO, String> teacherNameColumn = new TableColumn<>("Teacher Name");
        teacherNameColumn.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        schoolClassTableView.getColumns().add(teacherNameColumn);

        TableColumn<SchoolClassWithStudentCountDTO, String> gradeLevelColumn = new TableColumn<>("Grade Level");
        gradeLevelColumn.setCellValueFactory(new PropertyValueFactory<>("gradeLevel"));
        schoolClassTableView.getColumns().add(gradeLevelColumn);

        TableColumn<SchoolClassWithStudentCountDTO, String> schoolYearColumn = new TableColumn<>("School Year");
        schoolYearColumn.setCellValueFactory(new PropertyValueFactory<>("schoolYear"));
        schoolClassTableView.getColumns().add(schoolYearColumn);

        TableColumn<SchoolClassWithStudentCountDTO, String> studentCountColumn = new TableColumn<>("Student Count");
        studentCountColumn.setCellValueFactory(new PropertyValueFactory<>("studentCount"));
        schoolClassTableView.getColumns().add(studentCountColumn);

        List<SchoolClassWithStudentCountDTO> schoolClasses = schoolClassService.findAllWithStudentCount();
        items.addAll(schoolClasses);
        schoolClassTableView.setItems(items);
    }

    @FXML
    public void addSchoolClass() {
        routeService.switchScene(Route.ADD_SCHOOL_CLASS);
    }

    @FXML
    public void goToSchoolClassDetails() {
        SchoolClassWithStudentCountDTO selectedSchoolClass = schoolClassTableView.getSelectionModel().getSelectedItem();
        routeService.switchScene(Route.SCHOOL_CLASS_DETAILS, selectedSchoolClass.getId());
    }
}
