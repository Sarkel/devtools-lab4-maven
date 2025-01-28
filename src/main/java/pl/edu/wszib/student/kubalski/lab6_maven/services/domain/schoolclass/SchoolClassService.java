package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.SchoolClass;
import pl.edu.wszib.student.kubalski.lab6_maven.repositories.SchoolClassRepository;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.NewSchoolClassDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.SchoolClassDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.SchoolClassWithStudentCountDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.student.StudentService;
import pl.edu.wszib.student.kubalski.lab6_maven.util.DmlResult;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolClassService {
    private final SchoolClassRepository schoolClassRepository;
    private final StudentService studentService;
    private final Validator validator;
    private final SchoolClassMapper schoolClassMapper;

    public List<SchoolClassWithStudentCountDTO> findAllWithStudentCount() {
        List<SchoolClass> schoolClasses = schoolClassRepository.findAll();

        final Set<Long> schoolClassIds = schoolClasses.stream()
                .map(SchoolClass::getId)
                .collect(Collectors.toSet());

        final Map<Long, Integer> studentCountBySchoolClassId = studentService.findCountBySchoolClassId(schoolClassIds);

        return schoolClasses.stream()
                .map(schoolClassMapper::toWithStudentCountDTO)
                .peek(dto -> dto.setStudentCount(studentCountBySchoolClassId.getOrDefault(dto.getId(), 0)))
                .toList();
    }

    public Optional<SchoolClassDTO> findById(Long id) {
        return schoolClassRepository.findById(id).map(schoolClassMapper::toDTO);
    }

    public DmlResult create(NewSchoolClassDTO schoolClassDTO) {
        Set<ConstraintViolation<NewSchoolClassDTO>> errors = validator.validate(schoolClassDTO);

        DmlResult dmlResult = new DmlResult();

        if (errors.isEmpty()) {
            SchoolClass newSchoolClass = schoolClassMapper.fromNewRecordDTO(schoolClassDTO);

            SchoolClass saveSchoolClass = schoolClassRepository.save(newSchoolClass);
            dmlResult.setId(saveSchoolClass.getId());
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
