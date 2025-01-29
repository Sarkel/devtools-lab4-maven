package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.Student;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.SchoolClassMapper;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.NewStudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentWithAverageGradeDTO;

@Mapper(componentModel = "spring", uses = { SchoolClassMapper.class })
public interface StudentMapper {
    @Mapping(target = "averageGrade", ignore = true)
    StudentWithAverageGradeDTO toWithStudentCountDTO(Student source);

    @Mapping(source = "schoolClass.id", target = "schoolClassId")
    StudentDTO toDTO(Student source);

    @Mapping(target = "schoolClass", source = "schoolClassId", qualifiedByName = "schoolClassIdToSchoolClass" )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentGrades", ignore = true)
    Student fromNewRecordDTO(NewStudentDTO source);

    @Named("studentIdToStudent")
    default Student studentIdToStudent(Long id) {
        return Student.builder().id(id).build();
    }
}
