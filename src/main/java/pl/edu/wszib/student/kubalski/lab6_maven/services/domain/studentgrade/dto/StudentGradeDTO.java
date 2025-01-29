package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class StudentGradeDTO {
    private Long id;
    private Long studentId;
    private Long schoolClassId;
    private Integer grade;
    private Integer weight;
    private LocalDate date;
}
