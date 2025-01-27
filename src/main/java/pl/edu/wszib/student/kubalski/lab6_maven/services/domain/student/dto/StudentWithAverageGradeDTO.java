package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentWithAverageGradeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer averageGrade;
}
