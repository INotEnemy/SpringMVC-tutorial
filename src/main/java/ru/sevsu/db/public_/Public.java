/*
 * This file is generated by jOOQ.
 */
package ru.sevsu.db.public_;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.impl.SchemaImpl;

import ru.sevsu.db.DefaultCatalog;
import ru.sevsu.db.public_.tables.MyCourses;
import ru.sevsu.db.public_.tables.Table;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 400742585;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.my_courses</code>.
     */
    public final MyCourses MY_COURSES = ru.sevsu.db.public_.tables.MyCourses.MY_COURSES;

    /**
     * The table <code>public.table</code>.
     */
    public final Table TABLE = ru.sevsu.db.public_.tables.Table.TABLE;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
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
    public final List<org.jooq.Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<org.jooq.Table<?>> getTables0() {
        return Arrays.<org.jooq.Table<?>>asList(
            MyCourses.MY_COURSES,
            Table.TABLE);
    }
}
