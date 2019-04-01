package ru.sevsu.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sevsu.db.tables.pojos.Table;
import ru.sevsu.rest.configuration.URI;
import ru.sevsu.rest.service.TableService;

import java.util.List;

import static ru.sevsu.rest.configuration.URI.Table.TABLES;


@RestController(URI.INDEX)
@Api(value = URI.INDEX)
public class TableController {

    @Autowired
    TableService service;

    @RequestMapping(value = TABLES, method = RequestMethod.GET)
    @ApiOperation(value = "Возвращает список всех таблиц")
    private List<Table> get() {
        return service.getTables();
    }
}
