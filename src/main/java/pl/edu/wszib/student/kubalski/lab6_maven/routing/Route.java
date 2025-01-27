package pl.edu.wszib.student.kubalski.lab6_maven.routing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Route {
    SCHOOL_CLASS_LIST("school-class-list-view.fxml", "School classes"),
    ADD_SCHOOL_CLASS("add-school-class-view.fxml", "Add school class"),
    SCHOOL_CLASS_DETAILS("school-class-details-view.fxml", "School class details"),
    STUDENT_DETAILS("student-details-view.fxml", "Student details"),
    ADD_STUDENT("add-student-view.fxml", "Add student"),
    ADD_STUDENT_GRADE("add-student-grade-view.fxml", "Add grade");

    private final String viewName;

    private final String title;
}
