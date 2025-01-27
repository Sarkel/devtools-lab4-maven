package pl.edu.wszib.student.kubalski.lab6_maven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentsBySchoolClassId(Long schoolClassId);
}
