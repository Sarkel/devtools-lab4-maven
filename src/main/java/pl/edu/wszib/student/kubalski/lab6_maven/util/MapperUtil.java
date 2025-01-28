package pl.edu.wszib.student.kubalski.lab6_maven.util;

import org.mapstruct.Named;

import java.time.Year;

public class MapperUtil {
    @Named("stringToYear")
    public static Year parseYear(String year) {
        return year == null ? null : Year.parse(year);
    }

    @Named("stringToInt")
    public static Integer parseInt(String intString) {
        return intString == null ? null : Integer.parseInt(intString);
    }
}
