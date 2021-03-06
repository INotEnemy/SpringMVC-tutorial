/*
 * This file is generated by jOOQ.
 */
package ru.sevsu.db.tables.records;


import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import ru.sevsu.db.tables.Exercise;


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
public class ExerciseRecord extends UpdatableRecordImpl<ExerciseRecord> implements Record5<Integer, Date, Integer, Integer, String> {

    private static final long serialVersionUID = 1927460152;

    /**
     * Setter for <code>db.exercise.ex_id</code>.
     */
    public void setExId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.exercise.ex_id</code>.
     */
    public Integer getExId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.exercise.ex_date</code>.
     */
    public void setExDate(Date value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.exercise.ex_date</code>.
     */
    public Date getExDate() {
        return (Date) get(1);
    }

    /**
     * Setter for <code>db.exercise.ex_class_room</code>.
     */
    public void setExClassRoom(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.exercise.ex_class_room</code>.
     */
    public Integer getExClassRoom() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>db.exercise.course_num</code>.
     */
    public void setCourseNum(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>db.exercise.course_num</code>.
     */
    public Integer getCourseNum() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>db.exercise.ex_type</code>.
     */
    public void setExType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>db.exercise.ex_type</code>.
     */
    public String getExType() {
        return (String) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Date, Integer, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Date, Integer, Integer, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Exercise.EXERCISE.EX_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field2() {
        return Exercise.EXERCISE.EX_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Exercise.EXERCISE.EX_CLASS_ROOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Exercise.EXERCISE.COURSE_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Exercise.EXERCISE.EX_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getExId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component2() {
        return getExDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getExClassRoom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getCourseNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getExType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getExId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value2() {
        return getExDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getExClassRoom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getCourseNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getExType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseRecord value1(Integer value) {
        setExId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseRecord value2(Date value) {
        setExDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseRecord value3(Integer value) {
        setExClassRoom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseRecord value4(Integer value) {
        setCourseNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseRecord value5(String value) {
        setExType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExerciseRecord values(Integer value1, Date value2, Integer value3, Integer value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ExerciseRecord
     */
    public ExerciseRecord() {
        super(Exercise.EXERCISE);
    }

    /**
     * Create a detached, initialised ExerciseRecord
     */
    public ExerciseRecord(Integer exId, Date exDate, Integer exClassRoom, Integer courseNum, String exType) {
        super(Exercise.EXERCISE);

        set(0, exId);
        set(1, exDate);
        set(2, exClassRoom);
        set(3, courseNum);
        set(4, exType);
    }
}
