package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.SchoolClass;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.Student;
import pl.edu.wszib.student.kubalski.lab6_maven.repositories.StudentRepository;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.NewSchoolClassDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.NewStudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentWithAverageGradeDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.StudentGradeService;
import pl.edu.wszib.student.kubalski.lab6_maven.util.DmlResult;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentGradeService studentGradeService;
    private final StudentMapper studentMapper;
    private final Validator validator;

    public Optional<StudentDTO> findById(Long id) {
        return studentRepository.findById(id).map(studentMapper::toDTO);
    }

    public List<StudentWithAverageGradeDTO> findBySchoolClassId(Long schoolClassId) {
        final List<Student> students = studentRepository.findStudentsBySchoolClassId(schoolClassId);

        final Set<Long> studentIds = students.stream()
                .map(Student::getId)
                .collect(Collectors.toSet());

        Map<Long, Integer> averageGradesByStudentId = studentGradeService.getAverageGradesByStudentId(studentIds);

        return students.stream()
                .map(studentMapper::toWithStudentCountDTO)
                .peek(dto -> dto.setAverageGrade(averageGradesByStudentId.get(dto.getId())))
                .toList();
    }

    public Map<Long, Integer> findCountBySchoolClassId(Set<Long> schoolClassIds) {
        return studentRepository.findAllBySchoolClass_IdIn(schoolClassIds)
                .stream()
                .collect(Collectors.groupingBy(
                        s -> s.getSchoolClass().getId(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }

    public DmlResult create(NewStudentDTO newStudentDTO) {
        Set<ConstraintViolation<NewStudentDTO>> errors = validator.validate(newStudentDTO);

        DmlResult dmlResult = new DmlResult();

        if (errors.isEmpty()) {
            Student newStudent = studentMapper.fromNewRecordDTO(newStudentDTO);
            Student savedStudent =  studentRepository.save(newStudent);

            dmlResult.setId(savedStudent.getId());
        } else {
            errors.forEach(
                    error -> dmlResult.addError(
                            error.getPropertyPath().toString(), error.getMessage()
                    )
            );
        }

        return dmlResult;
    }
}
