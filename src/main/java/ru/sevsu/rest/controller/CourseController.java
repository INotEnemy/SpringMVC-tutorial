package ru.sevsu.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sevsu.db.tables.pojos.Course;
import ru.sevsu.rest.dto.CourseDto;
import ru.sevsu.rest.mapping.CourseMapping;
import ru.sevsu.rest.service.CourseService;
import ru.sevsu.rest.service.agg.AggCourseService;
import ru.sevsu.rest.service.agg.AggTeacherService;

import javax.validation.Valid;
import java.util.List;

import static ru.sevsu.rest.configuration.URI.Course.*;

@RestController(COURSES)
@Api(value = "Управление отображением таблицы предметов")
public class CourseController {
    @Autowired
    private CourseService service;

    @Autowired
    private CourseMapping mapping;

    @Autowired
    private AggTeacherService aggTeacherService;

    @Autowired
    private AggCourseService aggCourseService;

    @RequestMapping(value = COURSES , method = RequestMethod.GET)
    @ApiOperation(value = "Возвращает список всех предметов")
    public List<CourseDto> get() {
       return aggCourseService.listCourseDto();
    }

    @RequestMapping(
            value = COURSES,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE, "text/yaml"})
    @ApiOperation(value = "Создаёт предмет")
    public ResponseEntity<CourseDto> create (@Valid @RequestBody @ApiParam("Описание предмета") CourseDto inputDto) {
        if(service.checkTeacherAvailability(inputDto)){
            Course course = mapping.fromDto(inputDto);
            Course cour =  service.create(course);
            CourseDto dto = mapping.toDto(cour);

            return new ResponseEntity<CourseDto>(dto, HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = COURSES_NAME,
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE, "text/yaml"})
    @ApiOperation(value = "Обновляет предмет")
    public ResponseEntity<CourseDto> update (@Valid @RequestBody @ApiParam("Описание предмета") CourseDto inputDto) {

        if(service.checkTeacherAvailability(inputDto)){
            Course course = mapping.fromDto(inputDto);
            Course cour =  service.update(course);
            CourseDto dto = mapping.toDto(cour);

            return new ResponseEntity<CourseDto>(dto, HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = COURSES_NAME, method = RequestMethod.DELETE)
    @ApiOperation(value = "Удаляет предмет")
    public ResponseEntity delete(@PathVariable @ApiParam("Название предмета") String name) {
        aggTeacherService.deepDelete(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = COURSES_COUNT, method = RequestMethod.GET)
    @ApiOperation(value = "Подсчитывает число записей в таблице предметов")
    public ResponseEntity<Integer> count() {
        return new ResponseEntity( service.count(),HttpStatus.OK);
    }
}
