package ru.sevsu.rest.configuration;

public interface URI {

    String INDEX = "/";

    interface Table {
        String TABLES = "/tables";
    }

    interface Student {
        String STUDENTS       = "/students";
        String STUDENT_BY_FIO = "/students/{fio}";
    }
}
