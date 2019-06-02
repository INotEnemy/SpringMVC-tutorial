package ru.sevsu.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sevsu.rest.mapping.StudentMapping;

@Configuration
public class MappingConfiguration {

    @Bean
    public StudentMapping getStudentMapping() {
        return new StudentMapping();
    }

}
