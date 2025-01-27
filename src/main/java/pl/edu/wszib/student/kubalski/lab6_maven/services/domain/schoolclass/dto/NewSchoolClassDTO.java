package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewSchoolClassDTO {
    @Size(max = 255, message = "Name must not exceed 255 characters")
    @NotBlank(message = "Name must not be blank")
    private String name;

    @Size(max = 255, message = "Name must not exceed 255 characters")
    @NotBlank(message = "Name must not be blank")
    private String teacherName; // todo: normalize database to store teacher in separate table

    @NotNull(message = "Name must not be empty")
    @Pattern(regexp = "^\\d+$", message = "Grade Level needs to be positive number")
    private String gradeLevel;
}
