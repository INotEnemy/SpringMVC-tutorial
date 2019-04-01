package ru.sevsu.rest.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sevsu.db.db.tables.pojos.Student;
import ru.sevsu.rest.service.StudentService;

import java.util.List;

import static ru.sevsu.rest.configuration.URI.Student.STUDENTS;

@RestController(STUDENTS)
@Api(value = "Управление отображением таблицы студентов")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping( value = STUDENTS , method = RequestMethod.GET)
    @ApiOperation(value = "Возвращает список всех студентов")
    public List<Student> get() {
        return service.find();
    }
}
