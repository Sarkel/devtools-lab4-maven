package pl.edu.wszib.student.kubalski.lab6_maven.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Entity
@Table(schema = "lab6_maven")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String teacherName; // todo: normalize database to store teacher in separate table

    @Column(nullable = false, columnDefinition = "smallint")
    @Max(12)
    @PositiveOrZero
    private int gradeLevel;

    @Column(nullable = false)
    private Year schoolYear;

    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentGrade> studentGrades;
}
