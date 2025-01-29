package pl.edu.wszib.student.kubalski.lab6_maven.util;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class MapperUtil {
    @Named("stringToYear")
    public Year parseYear(String year) {
        return year == null ? null : Year.parse(year);
    }

    @Named("stringToInt")
    public Integer parseInt(String intString) {
        return intString == null ? null : Integer.parseInt(intString);
    }
}
