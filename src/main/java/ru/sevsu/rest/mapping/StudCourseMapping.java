package ru.sevsu.rest.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sevsu.db.tables.pojos.StudCourseLink;
import ru.sevsu.rest.dto.StudCourseDto;
import ru.sevsu.rest.service.CourseService;
import ru.sevsu.rest.service.StudentService;

public class StudCourseMapping extends PlainMapping<StudCourseLink, StudCourseDto> {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Override
    public StudCourseLink fromDto (StudCourseDto studCourseDto) {
        StudCourseLink studCourseLink = new StudCourseLink();
        studCourseLink.setStudNum(studentService.getIdByName(studCourseDto.getStudName()));
        studCourseLink.setCourseNum(courseService.getIdByName(studCourseDto.getCourseName()));
        return studCourseLink;
    }

    @Override
    public StudCourseDto toDto (StudCourseLink studCourseLink) {
        StudCourseDto studCourseDto = new StudCourseDto();
        studCourseDto.setStudName(studentService.getById(studCourseLink.getStudNum()).getFio());
        studCourseDto.setCourseName(courseService.getById(studCourseLink.getCourseNum()).getCourseName());
        return studCourseDto;
    }

}
