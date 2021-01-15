package ru.sevsu.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sevsu.rest.mapping.CourseMapping;
import ru.sevsu.rest.mapping.StudCourseMapping;
import ru.sevsu.rest.mapping.StudentMapping;
import ru.sevsu.rest.mapping.TeacherMapping;

@Configuration
public class MappingConfiguration {

    @Bean
    public StudentMapping getStudentMapping() {
        return new StudentMapping();
    }

    @Bean
    public TeacherMapping getTeacherMapping() { return new TeacherMapping(); }

    @Bean
    public CourseMapping getCourseMapping() { return new CourseMapping(); }

    @Bean
    public StudCourseMapping getStudCourseMapping() { return new StudCourseMapping(); }

}
