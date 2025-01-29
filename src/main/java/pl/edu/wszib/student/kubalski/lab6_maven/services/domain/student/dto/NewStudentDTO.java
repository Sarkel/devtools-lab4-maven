package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NewStudentDTO {
    @NotBlank(message = "First name must not be blank")
    @Size(max = 255, message = "First name must not exceed 255 characters")
    private String firstName;

    @Size(max = 255, message = "Last name must not exceed 255 characters")
    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @NotNull(message = "School class ID must not be empty")
    private Long schoolClassId;
}
