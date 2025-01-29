package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.SchoolClass;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.NewSchoolClassDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.SchoolClassDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.SchoolClassWithStudentCountDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.util.MapperUtil;

@Mapper(componentModel = "spring", uses = MapperUtil.class)
public interface SchoolClassMapper {
    @Mapping(target = "studentCount", ignore = true)
    SchoolClassWithStudentCountDTO toWithStudentCountDTO(SchoolClass source);

    @Mapping(source = "schoolYear", target = "schoolYear", qualifiedByName = "stringToYear")
    @Mapping(source = "gradeLevel", target = "gradeLevel", qualifiedByName = "stringToInt")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "studentGrades", ignore = true)
    SchoolClass fromNewRecordDTO(NewSchoolClassDTO source);

    SchoolClassDTO toDTO(SchoolClass source);
}
