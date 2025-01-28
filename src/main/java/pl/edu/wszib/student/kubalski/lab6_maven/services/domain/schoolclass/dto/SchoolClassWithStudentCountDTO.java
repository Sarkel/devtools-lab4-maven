package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class SchoolClassWithStudentCountDTO {
    private Long id;
    private String name;
    private String teacherName;
    private int gradeLevel;
    private Year schoolYear;
    private int studentCount;
}
