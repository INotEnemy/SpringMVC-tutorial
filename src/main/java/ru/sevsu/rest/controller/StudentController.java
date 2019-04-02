package ru.sevsu.rest.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sevsu.db.db.tables.pojos.Student;
import ru.sevsu.rest.dto.StudentDto;
import ru.sevsu.rest.mapping.StudentMapping;
import ru.sevsu.rest.service.StudentService;

import javax.validation.Valid;
import java.util.List;

import static ru.sevsu.rest.configuration.URI.Student.STUDENTS;
import static ru.sevsu.rest.configuration.URI.Student.STUDENT_BY_FIO;

@RestController(STUDENTS)
@Api(value = "Управление отображением таблицы студентов")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private StudentMapping mapping;

    @RequestMapping(value = STUDENTS , method = RequestMethod.GET)
    @ApiOperation(value = "Возвращает список всех студентов")
    public List<Student> get() {
        return service.find();
    }

    @RequestMapping(
            value = STUDENTS,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE, "text/yaml"})
    @ApiOperation(value = "Создаёт студента")
    public ResponseEntity<StudentDto> create (@Valid @RequestBody @ApiParam("Описание студента") StudentDto inputDto) {

        Student student = mapping.fromDto(inputDto);

        Student stud =  service.create(student);

        StudentDto dto = mapping.toDto(stud);

        return new ResponseEntity<StudentDto>(dto, HttpStatus.CREATED);

    }

    @RequestMapping(
            value = STUDENT_BY_FIO,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE, "text/yaml"})
    @ApiOperation(value = "Обновляет студента")
    public ResponseEntity<StudentDto> update (@Valid @RequestBody @ApiParam("Описание студента") StudentDto inputDto) {

        Student student = mapping.fromDto(inputDto);

        Student stud =  service.update(student);

        StudentDto dto = mapping.toDto(stud);

        return new ResponseEntity<StudentDto>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(value = STUDENT_BY_FIO, method = RequestMethod.DELETE)
    @ApiOperation(value = "Удаляет студента")
    public ResponseEntity delete(@PathVariable @ApiParam("Фио студента") String fio) {
        service.delete(fio);

        return new ResponseEntity(HttpStatus.OK);
    }
}
