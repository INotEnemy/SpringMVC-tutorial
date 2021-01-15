package ru.sevsu.rest.service.agg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sevsu.rest.dto.StudCourseDto;
import ru.sevsu.rest.service.CourseService;
import ru.sevsu.rest.service.StudCourseImplService;
import ru.sevsu.rest.service.StudCourseService;
import ru.sevsu.rest.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AggStudCourseLinkService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudCourseService studCourseService;

    @Autowired
    private StudCourseImplService studCourseImplService;

    public List<StudCourseDto> listStudCourseLinkDto() {
        return studCourseService.find()
                .stream()
                .map(studCourse -> {
                    StudCourseDto studCourseDto = new StudCourseDto();
                    studCourseDto.setStudName(studentService.findById(studCourse.getStudNum()).get().getFio());
                    studCourseDto.setCourseName(courseService.findById(studCourse.getCourseNum()).get().getCourseName());
                    return studCourseDto;
                }).collect(Collectors.toList());
    }

    public void delete(String studName, String courseName){
        Integer studNum = studentService.getIdByName(studName);
        Integer courseNum = courseService.getIdByName(courseName);
        studCourseImplService.delete(studNum, courseNum);
    }


}
