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
import pl.edu.wszib.student.kubalski.lab6_maven.entities.SchoolClass;
import pl.edu.wszib.student.kubalski.lab6_maven.routing.RouteService;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.SchoolClassService;

import java.util.List;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class SchoolClassListViewController {

    private final SchoolClassService schoolClassService;

    private final RouteService routeService;

    @FXML
    private TableView<SchoolClass> schoolClassTableView;

    private final ObservableList<SchoolClass> items = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        TableColumn<SchoolClass, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        schoolClassTableView.getColumns().add(nameColumn);

        TableColumn<SchoolClass, String> teacherNameColumn = new TableColumn<>("Teacher Name");
        teacherNameColumn.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        schoolClassTableView.getColumns().add(teacherNameColumn);

        TableColumn<SchoolClass, String> gradeLevelColumn = new TableColumn<>("Grade Level");
        gradeLevelColumn.setCellValueFactory(new PropertyValueFactory<>("gradeLevel"));
        schoolClassTableView.getColumns().add(gradeLevelColumn);

        List<SchoolClass> schoolClasses = schoolClassService.findAll();
        items.addAll(schoolClasses);
        schoolClassTableView.setItems(items);
    }

    @FXML
    public void addSchoolClass() {
        routeService.switchScene(Route.ADD_SCHOOL_CLASS);
    }

    @FXML
    public void goToSchoolClassDetails() {
        SchoolClass selectedSchoolClass = schoolClassTableView.getSelectionModel().getSelectedItem();
        routeService.switchScene(Route.SCHOOL_CLASS_DETAILS, selectedSchoolClass.getId());
    }
}
