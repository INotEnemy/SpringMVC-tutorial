package ru.sevsu.rest.service.agg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sevsu.rest.dto.CourseDto;
import ru.sevsu.rest.service.CourseService;
import ru.sevsu.rest.service.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AggCourseService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    public List<CourseDto> listCourseDto() {
        return courseService.find()
                .stream()
                .map(course -> {
                    CourseDto courseDto = new CourseDto(course);
                    courseDto.setTeacherName(teacherService.findById(course.getTeacherNum()).get().getTeacherFio());
                    return courseDto;
                }).collect(Collectors.toList());
    }

}
