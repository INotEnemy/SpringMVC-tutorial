package ru.sevsu.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import ru.sevsu.db.tables.pojos.Course;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    @ApiModelProperty(notes = "Автор курса", example = "Fisun V. A.")
    private String teacherName;

    @NonNull
    @ApiModelProperty(notes = "Название курса", example = "Компьютерная логика")
    private String  courseName;

    @ApiModelProperty(notes = "Описание курса", example = "Для студентов 2-го курса технических специальностей")
    private String  courseDescription;

    @ApiModelProperty(notes = "*Название курса*", example = "xxxxxxx")
    private String  tmpCourseName;

    public CourseDto (Course course){
        this.courseName = course.getCourseName();
        this.courseDescription = course.getCourseDescription();
        this.tmpCourseName = course.getTmpCourseName();
    }

}

