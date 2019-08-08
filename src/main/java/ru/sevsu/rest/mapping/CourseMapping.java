package ru.sevsu.rest.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sevsu.db.tables.pojos.Course;
import ru.sevsu.rest.dto.CourseDto;
import ru.sevsu.rest.service.TeacherService;


public class CourseMapping extends PlainMapping <Course, CourseDto> {

    @Autowired
    private TeacherService teacherService;

    @Override
    public Course fromDto(CourseDto courseDto)
    {
        Course course = new Course();
        course.setCourseName(courseDto.getCourseName());
        course.setTeacherNum(teacherService.getIdByName(courseDto.getTeacherName()));
        course.setCourseDescription(courseDto.getCourseDescription());
        course.setTmpCourseName(courseDto.getTmpCourseName());
        return course;
    }

    @Override
    public CourseDto toDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseName(course.getCourseName());
        courseDto.setTeacherName(teacherService.getById(course.getTeacherNum()).getTeacherFio());
        courseDto.setCourseDescription(course.getCourseDescription());
        courseDto.setTmpCourseName(course.getTmpCourseName());
        return courseDto;
    }
}
