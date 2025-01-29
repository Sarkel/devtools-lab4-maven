package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto.StudentGradeDTO;

@Mapper(componentModel = "spring")
public interface StudentGradeMapper {
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "schoolClassId", source = "schoolClass.id")
    StudentGradeDTO toDTO(StudentGrade source);
}
