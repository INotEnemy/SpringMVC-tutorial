package ru.sevsu.rest.service;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sevsu.db.tables.pojos.Table;

import java.util.List;

import static ru.sevsu.db.tables.Table.TABLE;


@Service
public class TableService {
    @Autowired
    protected DSLContext context;


    public List<Table> getTables() {
        return context.select()
                .from(TABLE)
                .fetch()
                .into(Table.class);
    }
}
