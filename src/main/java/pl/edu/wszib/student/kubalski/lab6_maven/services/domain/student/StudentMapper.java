package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.SchoolClass;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.Student;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.NewStudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentWithAverageGradeDTO;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "averageGrade", ignore = true)
    StudentWithAverageGradeDTO toWithStudentCountDTO(Student source);

    @Mapping(source = "schoolClass.id", target = "schoolClassId")
    StudentDTO toDTO(Student source);

    @Mapping(target = "schoolClass", source = "schoolClassId", qualifiedByName = "schoolClassIdToSchoolClass" )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentGrades", ignore = true)
    Student fromNewRecordDTO(NewStudentDTO source);

    @Named( "schoolClassIdToSchoolClass")
    default SchoolClass schoolClassIdToSchoolClass(Long id) {
        return SchoolClass.builder().id(id).build();
    }
}
