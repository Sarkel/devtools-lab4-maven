package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.Student;
import pl.edu.wszib.student.kubalski.lab6_maven.repositories.StudentRepository;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentWithAverageGradeDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.StudentGradeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentGradeService studentGradeService;
    private final StudentMapper studentMapper;

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
        return studentRepository.findAllBySchoolClassIds(schoolClassIds)
                .stream()
                .collect(Collectors.groupingBy(
                        s -> s.getSchoolClass().getId(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }
}
