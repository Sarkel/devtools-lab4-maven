package pl.edu.wszib.student.kubalski.lab6_maven.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(schema = "lab6_maven")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(5)
    @Positive
    @Column(nullable = false)
    private int grade;

    @Max(3)
    @Positive
    @Column(nullable = false)
    @ColumnDefault(value = "0")
    private int weight;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "school_class_id", nullable = false)
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
