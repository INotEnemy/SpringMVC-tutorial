package ru.sevsu.rest.service;

import org.springframework.stereotype.Service;
import ru.sevsu.db.public_.tables.pojos.Table;

import java.util.List;

import static ru.sevsu.db.public_.tables.Table.TABLE;


@Service
public class TableService extends JooqAbstractService {

    public List<Table> getTables() {
        return context.select()
                .from(TABLE)
                .fetch()
                .into(Table.class);
    }
}
