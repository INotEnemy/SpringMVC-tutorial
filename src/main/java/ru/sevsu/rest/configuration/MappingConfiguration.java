package ru.sevsu.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sevsu.rest.mapping.StudentMapping;
import ru.sevsu.rest.mapping.TableMapping;

@Configuration
public class MappingConfiguration {
    
    @Bean
    public TableMapping getTableMapping() {
        return new TableMapping();
    }

    @Bean
    public StudentMapping getStudentMapping() {
        return new StudentMapping();
    }

}
