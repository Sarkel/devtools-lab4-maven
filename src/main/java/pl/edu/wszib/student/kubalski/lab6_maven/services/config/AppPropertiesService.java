package pl.edu.wszib.student.kubalski.lab6_maven.services.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "app.property")
@Getter
@Setter
public class AppPropertiesService {
    private int width;
    private int height;
}
