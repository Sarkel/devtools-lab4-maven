package pl.edu.wszib.student.kubalski.lab6_maven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {
}
