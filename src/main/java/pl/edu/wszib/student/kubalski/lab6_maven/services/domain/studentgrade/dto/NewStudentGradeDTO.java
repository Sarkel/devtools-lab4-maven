package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class NewStudentGradeDTO {
    private Long studentId;
    private Long schoolClassId;
    private String grade;
    private String weight;
    private LocalDate date;
}
