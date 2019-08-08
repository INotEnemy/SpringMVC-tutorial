package ru.sevsu.rest.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sevsu.db.tables.pojos.StudCourseLink;
import ru.sevsu.rest.dto.StudCourseDto;
import ru.sevsu.rest.mapping.StudCourseMapping;
import ru.sevsu.rest.service.StudCourseService;
import ru.sevsu.rest.service.agg.AggStudCourseLinkService;

import javax.validation.Valid;
import java.util.List;

import static ru.sevsu.rest.configuration.URI.StudCourse.*;

@RestController(STUD_COURSE_LINKS)
@Api(value = "Управление отображением таблицы предметов")
public class StudCourseController {

    @Autowired
    private StudCourseService service;

    @Autowired
    private StudCourseMapping mapping;

    @Autowired
    private AggStudCourseLinkService aggStudCourseLinkService;

    @RequestMapping(value = STUD_COURSE_LINKS , method = RequestMethod.GET)
    @ApiOperation(value = "Возвращает список всех связей между студентами и курсами")
    public List<StudCourseDto> get() {
        return aggStudCourseLinkService.listStudCourseLinkDto();
    }

    @RequestMapping(
            value = STUD_COURSE_LINKS,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE, "text/yaml"})
    @ApiOperation(value = "Созадаёт связь между студентом и курсом")
    public ResponseEntity<StudCourseDto> create (@Valid @RequestBody @ApiParam("Описание связи между студентом и курсом") StudCourseDto inputDto) {

        StudCourseLink link = mapping.fromDto(inputDto);
        StudCourseLink link2 = service.create(link);
        StudCourseDto dto = mapping.toDto(link2);

        return new ResponseEntity<StudCourseDto>(dto, HttpStatus.CREATED);
    }

//  Обновление не реализовано!!!
//--------------------------------------------------------------------------------
//    @RequestMapping(
//            value = STUD_COURSE_LINKS,
//            method = RequestMethod.PUT,
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = {MediaType.APPLICATION_JSON_VALUE, "text/yaml"})
//    @ApiOperation(value = "Обновляет связь между студентом и курсом")
//    public ResponseEntity<StudCourseDto> update (@Valid @RequestBody @ApiParam("Описание связи между студентом и курсом") StudCourseDto inputDto) {
//
//        StudCourseLink link = mapping.fromDto(inputDto);
//        StudCourseLink link2 =  service.update(link);
//        StudCourseDto dto = mapping.toDto(link2);
//
//        return new ResponseEntity<StudCourseDto>(dto, HttpStatus.CREATED);
//    }

    @RequestMapping(value = STUD_COURSE_LINKS_NUMS, method = RequestMethod.DELETE)
    @ApiOperation(value = "Удаляет связь между студентом и курсами")
    public ResponseEntity delete(@PathVariable @ApiParam("Фио студента") String studName, @PathVariable @ApiParam("Название курса")String courseName) {
        aggStudCourseLinkService.delete(studName, courseName);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = STUD_COURSE_LINKS_COUNT, method = RequestMethod.GET)
    @ApiOperation(value = "Подсчитывает число записей в таблице связей между студентом и курсами")
    public ResponseEntity<Integer> count() {
        return new ResponseEntity( service.count(),HttpStatus.OK);
    }

}
