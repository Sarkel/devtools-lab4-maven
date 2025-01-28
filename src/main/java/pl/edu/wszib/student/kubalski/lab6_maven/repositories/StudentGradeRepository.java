package pl.edu.wszib.student.kubalski.lab6_maven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {
    List<StudentGrade> findAllByStudentIds(Set<Long> studentIds);
}
