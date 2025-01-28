package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto;

import lombok.Data;

import java.time.Year;

@Data
public class SchoolClassDTO {
    private Long id;
    private String name;
    private String teacherName;
    private int gradeLevel;
    private Year schoolYear;
}
