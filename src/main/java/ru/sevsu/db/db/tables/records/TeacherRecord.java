/*
 * This file is generated by jOOQ.
 */
package ru.sevsu.db.db.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import ru.sevsu.db.db.tables.Teacher;


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
public class TeacherRecord extends UpdatableRecordImpl<TeacherRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 550193195;

    /**
     * Setter for <code>db.teacher.teacher_num</code>.
     */
    public void setTeacherNum(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.teacher.teacher_num</code>.
     */
    public Integer getTeacherNum() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.teacher.teacher_fio</code>.
     */
    public void setTeacherFio(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.teacher.teacher_fio</code>.
     */
    public String getTeacherFio() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Teacher.TEACHER.TEACHER_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Teacher.TEACHER.TEACHER_FIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getTeacherNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getTeacherFio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getTeacherNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTeacherFio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value1(Integer value) {
        setTeacherNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord value2(String value) {
        setTeacherFio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TeacherRecord
     */
    public TeacherRecord() {
        super(Teacher.TEACHER);
    }

    /**
     * Create a detached, initialised TeacherRecord
     */
    public TeacherRecord(Integer teacherNum, String teacherFio) {
        super(Teacher.TEACHER);

        set(0, teacherNum);
        set(1, teacherFio);
    }
}
