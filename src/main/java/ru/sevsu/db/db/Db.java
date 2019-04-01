/*
 * This file is generated by jOOQ.
 */
package ru.sevsu.db.db;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import ru.sevsu.db.DefaultCatalog;
import ru.sevsu.db.db.tables.Student;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Db extends SchemaImpl {

    private static final long serialVersionUID = 480161213;

    /**
     * The reference instance of <code>db</code>
     */
    public static final Db DB = new Db();

    /**
     * The table <code>db.student</code>.
     */
    public final Student STUDENT = ru.sevsu.db.db.tables.Student.STUDENT;

    /**
     * No further instances allowed
     */
    private Db() {
        super("db", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.SEQ_GET_ID);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Student.STUDENT);
    }
}
