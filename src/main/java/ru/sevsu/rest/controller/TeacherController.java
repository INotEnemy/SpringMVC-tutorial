package ru.sevsu.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sevsu.db.tables.pojos.Teacher;
import ru.sevsu.rest.mapping.TeacherMapping;
import ru.sevsu.rest.dto.TeacherDto;
import ru.sevsu.rest.service.TeacherService;

import javax.validation.Valid;
import java.util.List;

import static ru.sevsu.rest.configuration.URI.Teacher.*;

@RestController(TEACHERS)
@Api(value = "Управление отображением таблицы преподавателей")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @Autowired
    private TeacherMapping mapping;

    @RequestMapping(value = TEACHERS , method = RequestMethod.GET)
    @ApiOperation(value = "Возвращает список всех преподавателей")
    public List<Teacher> get() {
        return service.find();
    }

    @RequestMapping(
            value = TEACHERS,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE, "text/yaml"})

    @ApiOperation(value = "Создаёт преподавателя")
    public ResponseEntity<TeacherDto> create (@Valid @RequestBody @ApiParam("Описание преподователя") TeacherDto inputDto) {

        Teacher teacher = mapping.fromDto(inputDto);
        Teacher teach =  service.create(teacher);
        TeacherDto dto = mapping.toDto(teach);

        return new ResponseEntity<TeacherDto>(dto, HttpStatus.CREATED);

    }

    @RequestMapping(
            value = TEACHER_BY_FIO,
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE, "text/yaml"})
    @ApiOperation(value = "Обновляет преподавателя")
    public ResponseEntity<TeacherDto> update (@Valid @RequestBody @ApiParam("Описание преподавателя") TeacherDto inputDto) {

        Teacher teacher = mapping.fromDto(inputDto);
        Teacher teach =  service.update(teacher);
        TeacherDto dto = mapping.toDto(teach);

        return new ResponseEntity<TeacherDto>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(value = TEACHER_BY_FIO, method = RequestMethod.DELETE)
    @ApiOperation(value = "Удаляет преподавателя")
    public ResponseEntity delete(@PathVariable @ApiParam("Фио преподавателя") String fio) {
        service.delete(fio);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = TEACHER_COUNT, method = RequestMethod.GET)
    @ApiOperation(value = "Подсчитывает число записей в таблице преподавателей")
    public ResponseEntity<Integer> count() {
        return new ResponseEntity( service.count(),HttpStatus.OK);
    }

}
