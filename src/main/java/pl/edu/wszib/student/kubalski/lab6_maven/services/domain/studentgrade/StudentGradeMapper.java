package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.SchoolClassMapper;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.StudentMapper;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto.NewStudentGradeDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto.StudentGradeDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.util.MapperUtil;

@Mapper(componentModel = "spring", uses = { MapperUtil.class, SchoolClassMapper.class, StudentMapper.class })
public interface StudentGradeMapper {
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "schoolClassId", source = "schoolClass.id")
    StudentGradeDTO toDTO(StudentGrade source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schoolClass", source = "schoolClassId", qualifiedByName = "schoolClassIdToSchoolClass" )
    @Mapping(target = "student", source = "studentId", qualifiedByName = "studentIdToStudent")
    @Mapping(target = "weight", source = "weight", qualifiedByName = "stringToInt")
    @Mapping(target = "grade", source = "grade", qualifiedByName = "stringToInt")
    StudentGrade fromNewRecordDTO(NewStudentGradeDTO source);
}
