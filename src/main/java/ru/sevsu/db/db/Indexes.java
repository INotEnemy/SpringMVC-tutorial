/*
 * This file is generated by jOOQ.
 */
package ru.sevsu.db.db;


import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import ru.sevsu.db.db.tables.Course;
import ru.sevsu.db.db.tables.Exercise;
import ru.sevsu.db.db.tables.StudCourseLink;
import ru.sevsu.db.db.tables.Student;
import ru.sevsu.db.db.tables.Teacher;


/**
 * A class modelling indexes of tables of the <code>db</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index COURSE_PKEY = Indexes0.COURSE_PKEY;
    public static final Index EXERCISE_PKEY = Indexes0.EXERCISE_PKEY;
    public static final Index STUD_COURSE_LINK_PKEY = Indexes0.STUD_COURSE_LINK_PKEY;
    public static final Index ID = Indexes0.ID;
    public static final Index STUDENT_PKEY = Indexes0.STUDENT_PKEY;
    public static final Index STUDENT_ZACHNUM_KEY = Indexes0.STUDENT_ZACHNUM_KEY;
    public static final Index TEACHER_PKEY = Indexes0.TEACHER_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index COURSE_PKEY = Internal.createIndex("course_pkey", Course.COURSE, new OrderField[] { Course.COURSE.COURSE_NUM }, true);
        public static Index EXERCISE_PKEY = Internal.createIndex("exercise_pkey", Exercise.EXERCISE, new OrderField[] { Exercise.EXERCISE.EX_ID }, true);
        public static Index STUD_COURSE_LINK_PKEY = Internal.createIndex("stud_course_link_pkey", StudCourseLink.STUD_COURSE_LINK, new OrderField[] { StudCourseLink.STUD_COURSE_LINK.SCL_ID }, true);
        public static Index ID = Internal.createIndex("id", Student.STUDENT, new OrderField[] { Student.STUDENT.FIO.desc() }, false);
        public static Index STUDENT_PKEY = Internal.createIndex("student_pkey", Student.STUDENT, new OrderField[] { Student.STUDENT.STUD_NUM }, true);
        public static Index STUDENT_ZACHNUM_KEY = Internal.createIndex("student_zachnum_key", Student.STUDENT, new OrderField[] { Student.STUDENT.ZACHNUM }, true);
        public static Index TEACHER_PKEY = Internal.createIndex("teacher_pkey", Teacher.TEACHER, new OrderField[] { Teacher.TEACHER.TEACHER_NUM }, true);
    }
}