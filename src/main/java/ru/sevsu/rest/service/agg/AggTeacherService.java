package ru.sevsu.rest.service.agg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sevsu.db.tables.pojos.Course;
import ru.sevsu.db.tables.pojos.Teacher;
import ru.sevsu.rest.service.CourseService;
import ru.sevsu.rest.service.TeacherService;

import java.util.Optional;

@Service
public class AggTeacherService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    public void deepDelete (String name) {
        Optional<Teacher> teacher = teacherService.findByName(name);
        Integer numTeacher = teacher.get().getTeacherNum();
        Course course = courseService.findCourseByTeacherNum(numTeacher);

        if (course != null) {
            courseService.delete(course.getCourseName());
        }

        teacherService.delete(name);
    }
}
