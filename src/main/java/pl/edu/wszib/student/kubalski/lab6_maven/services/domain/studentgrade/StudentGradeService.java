package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.StudentGrade;
import pl.edu.wszib.student.kubalski.lab6_maven.repositories.StudentGradeRepository;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto.NewStudentGradeDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.studentgrade.dto.StudentGradeDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.util.DmlResult;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentGradeService {
    private final StudentGradeRepository studentGradeRepository;
    private final StudentGradeMapper studentGradeMapper;
    private final Validator validator;

    public List<StudentGradeDTO> findStudentGradesByStudentId(Long studentId) {
        return studentGradeRepository.findAllByStudent_Id(studentId).stream()
                .map(studentGradeMapper::toDTO)
                .sorted(Comparator.comparing(StudentGradeDTO::getDate)
                        .thenComparing(Comparator.comparing(StudentGradeDTO::getWeight)
                                .reversed())
                )
                .toList();
    }

    public DmlResult create(NewStudentGradeDTO newStudentGradeDTO) {
        Set<ConstraintViolation<NewStudentGradeDTO>> errors = validator.validate(newStudentGradeDTO);

        DmlResult dmlResult = new DmlResult();

        if (errors.isEmpty()) {
            StudentGrade newStudentGrade = studentGradeMapper.fromNewRecordDTO(newStudentGradeDTO);
            StudentGrade savedStudentGrade = studentGradeRepository.save(newStudentGrade);

            dmlResult.setId(savedStudentGrade.getId());
        } else {
            errors.forEach(
                    error -> dmlResult.addError(
                            error.getPropertyPath().toString(), error.getMessage()
                    )
            );
        }

        return dmlResult;
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
