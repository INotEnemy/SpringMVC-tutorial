package ru.sevsu.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sevsu.rest.mapping.PlainMapping;
import ru.sevsu.rest.mapping.StudentMapping;
import ru.sevsu.rest.mapping.TableMapping;

@Configuration
public class MappingConfiguration {

    @Bean
    public PlainMapping getPlainMapping() {
        return new PlainMapping();
    }

    @Bean
    public TableMapping getTableMapping() {
        return new TableMapping();
    }

    @Bean
    public StudentMapping getStudentMapping() {
        return new StudentMapping();
    }

}
