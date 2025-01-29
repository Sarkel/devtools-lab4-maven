package pl.edu.wszib.student.kubalski.lab6_maven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {
    List<StudentGrade> findAllByStudent_IdIn(Collection<Long> studentIds);

    List<StudentGrade> findAllByStudent_Id(Long studentId);
}
