package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.Student;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentWithAverageGradeDTO;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentWithAverageGradeDTO toWithStudentCountDTO(Student source);

    @Mapping(source = "schoolClass.id", target = "schoolClassId")
    StudentDTO toDTO(Student source);
}
