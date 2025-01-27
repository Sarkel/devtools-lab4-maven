package pl.edu.wszib.student.kubalski.lab6_maven.util;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class DmlResult {
    private final Map<String, List<String>> errors = new HashMap<>();

    @Setter
    private Long id;

    public void addError(String field, String error) {
        if (!errors.containsKey(field)) {
            errors.put(field, List.of(error));
        } else {
            errors.get(field).add(error);
        }
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
