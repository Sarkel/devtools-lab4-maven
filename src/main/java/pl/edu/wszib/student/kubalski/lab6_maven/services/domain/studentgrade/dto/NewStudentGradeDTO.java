package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class NewStudentGradeDTO {
    @NotNull(message = "Student ID cannot be empty")
    private Long studentId;

    @NotNull(message = "School class ID cannot be empty")
    private Long schoolClassId;

    @NotNull(message = "Grade cannot be empty")
    @Pattern(regexp = "^[1-5]$", message = "Grade needs to be 1-5")
    private String grade;

    @NotNull(message = "Weight cannot be empty")
    @Pattern(regexp = "^[1-3]$", message = "Weight needs to be 1-3")
    private String weight;

    @NotNull(message = "Date cannot be empty")
    @PastOrPresent(message = "Dane cannot be in the future")
    private LocalDate date;
}
