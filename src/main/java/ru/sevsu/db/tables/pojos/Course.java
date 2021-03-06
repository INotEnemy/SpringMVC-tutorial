/*
 * This file is generated by jOOQ.
 */
package ru.sevsu.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class Course implements Serializable {

    private static final long serialVersionUID = -1663591617;

    private Integer courseNum;
    private Integer teacherNum;
    private String  courseName;
    private String  courseDescription;
    private String  tmpCourseName;

    public Course() {}

    public Course(Course value) {
        this.courseNum = value.courseNum;
        this.teacherNum = value.teacherNum;
        this.courseName = value.courseName;
        this.courseDescription = value.courseDescription;
        this.tmpCourseName = value.tmpCourseName;
    }

    public Course(
        Integer courseNum,
        Integer teacherNum,
        String  courseName,
        String  courseDescription,
        String  tmpCourseName
    ) {
        this.courseNum = courseNum;
        this.teacherNum = teacherNum;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.tmpCourseName = tmpCourseName;
    }

    public Integer getCourseNum() {
        return this.courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public Integer getTeacherNum() {
        return this.teacherNum;
    }

    public void setTeacherNum(Integer teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return this.courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getTmpCourseName() {
        return this.tmpCourseName;
    }

    public void setTmpCourseName(String tmpCourseName) {
        this.tmpCourseName = tmpCourseName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Course (");

        sb.append(courseNum);
        sb.append(", ").append(teacherNum);
        sb.append(", ").append(courseName);
        sb.append(", ").append(courseDescription);
        sb.append(", ").append(tmpCourseName);

        sb.append(")");
        return sb.toString();
    }
}
