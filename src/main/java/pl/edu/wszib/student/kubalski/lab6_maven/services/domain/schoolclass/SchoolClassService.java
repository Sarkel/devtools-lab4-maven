package pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.student.kubalski.lab6_maven.entities.SchoolClass;
import pl.edu.wszib.student.kubalski.lab6_maven.repositories.SchoolClassRepository;
import pl.edu.wszib.student.kubalski.lab6_maven.services.domain.schoolclass.dto.NewSchoolClassDTO;
import pl.edu.wszib.student.kubalski.lab6_maven.util.DmlResult;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SchoolClassService {
    private final SchoolClassRepository schoolClassRepository;
    private final Validator validator;

    public List<SchoolClass> findAll() {
        return schoolClassRepository.findAll();
    }

    public Optional<SchoolClass> findById(Long id) {
        return schoolClassRepository.findById(id);
    }

    public DmlResult create(NewSchoolClassDTO newSchoolClassDTO) {
        Set<ConstraintViolation<NewSchoolClassDTO>> errors = validator.validate(newSchoolClassDTO);

        DmlResult dmlResult = new DmlResult();

        if (errors.isEmpty()) {
            SchoolClass newSchoolClass = SchoolClass.builder()
                    .name(newSchoolClassDTO.getName())
                    .teacherName(newSchoolClassDTO.getTeacherName())
                    .gradeLevel(Integer.parseInt(newSchoolClassDTO.getGradeLevel()))
                    .build();

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
