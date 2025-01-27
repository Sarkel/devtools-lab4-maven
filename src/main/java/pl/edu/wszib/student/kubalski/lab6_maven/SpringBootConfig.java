package pl.edu.wszib.student.kubalski.lab6_maven;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration(proxyBeanMethods=false)
@ConfigurationPropertiesScan
public class SpringBootConfig {
}
