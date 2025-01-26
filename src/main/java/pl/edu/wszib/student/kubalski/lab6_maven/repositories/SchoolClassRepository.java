package pl.edu.wszib.student.kubalski.lab6_maven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.SchoolClass;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
}
