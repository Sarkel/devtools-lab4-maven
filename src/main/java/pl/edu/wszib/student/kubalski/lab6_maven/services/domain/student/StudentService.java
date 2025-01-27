package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.Student;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;
import pl.edu.wszib.student.kubalski.lab6_maven.repositories.StudentRepository;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.dto.StudentWithAverageGradeDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<StudentWithAverageGradeDTO> findBySchoolClassId(Long schoolClassId) {
        return studentRepository.findStudentsBySchoolClassId(schoolClassId).stream()
                .map(s -> {
                    List<StudentGrade> averageGrades = s.getStudentGrades();

                    int totalWeight = averageGrades.stream()
                            .mapToInt(StudentGrade::getWeight)
                            .sum();

                    int totalWeightedGrade = averageGrades.stream()
                            .mapToInt(sg -> sg.getWeight() * sg.getGrade())
                            .sum();

                    Integer averageGrade = totalWeight == 0 ? null : totalWeightedGrade / totalWeight;

                    return StudentWithAverageGradeDTO.builder()
                            .id(s.getId())
                            .firstName(s.getFirstName())
                            .lastName(s.getLastName())
                            .averageGrade(averageGrade)
                            .build();
                })
                .toList();
    }
}
