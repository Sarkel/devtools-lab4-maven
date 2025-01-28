package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;
import pl.edu.wszib.student.kubalski.lab6_maven.repositories.StudentGradeRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentGradeService {
    private final StudentGradeRepository studentGradeRepository;

    public Map<Long, Double> getAverageGradesByStudentIds(Set<Long> studentIds) {
        Map<Long, List<StudentGrade>> results = studentGradeRepository.findAllByStudentIds(studentIds)
                .stream()
                .collect(Collectors.groupingBy(sg -> sg.getStudent().getId()));

        return results.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .mapToInt(StudentGrade::getGrade)
                                .average()
                                .orElse(0.0)
                ));
    }
}
