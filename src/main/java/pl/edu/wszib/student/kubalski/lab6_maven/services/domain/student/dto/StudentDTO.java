package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long schoolClassId;
}
