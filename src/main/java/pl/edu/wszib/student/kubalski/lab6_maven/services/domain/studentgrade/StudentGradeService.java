package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;
import pl.edu.wszib.student.kubalski.lab6_maven.repositories.StudentGradeRepository;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto.StudentGradeDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentGradeService {
    private final StudentGradeRepository studentGradeRepository;
    private final StudentGradeMapper studentGradeMapper;

    public List<StudentGradeDTO> findStudentGradesByStudentId(Long studentId) {
        return studentGradeRepository.findAllByStudent_Id(studentId).stream()
                .map(studentGradeMapper::toDTO)
                .toList();
    }

    public Map<Long, Integer> getAverageGradesByStudentId(Set<Long> studentIds) {
        return studentGradeRepository.findAllByStudent_IdIn(studentIds)
                .stream()
                .collect(Collectors.groupingBy(sg -> sg.getStudent().getId()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> calculateWeightedAverageGrade(entry.getValue())
                ));
    }

    private Integer calculateWeightedAverageGrade(List<StudentGrade> studentGrades) {
        int summedWeights = 0;
        int summedWeightedGrades = 0;

        for (StudentGrade sg : studentGrades) {
            summedWeights += sg.getWeight();
            summedWeightedGrades += sg.getGrade() * sg.getWeight();
        }

        return summedWeightedGrades / summedWeights;

    }
}
