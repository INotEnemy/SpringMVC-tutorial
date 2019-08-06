package ru.sevsu.rest.configuration;

public interface URI {

    String INDEX = "/";


    interface Student {
        String STUDENTS             = "/students";
        String STUDENT_BY_FIO       = "/students/{fio}";
        String STUDENTS_COUNT       = "/students/count";
        String STUDENTS_MAX         = "/students/max";
        String STUDENTS_AVG         = "/students/avg";
    }

    interface Teacher {
        String TEACHERS             = "/teachers";
        String TEACHER_BY_FIO       = "/teachers/{fio}";
        String TEACHER_COUNT        = "/teachers/count";
    }

    interface Course {
        String COURSES              = "/courses";
        String COURSES_NAME         = "/courses/{name}";
        String COURSES_COUNT        = "/courses/count";
    }
}
