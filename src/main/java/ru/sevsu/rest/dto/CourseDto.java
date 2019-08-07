package ru.sevsu.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    @ApiModelProperty(notes = "Автор курса", example = "7")
    private String teacherNum;

    @NonNull
    @ApiModelProperty(notes = "Название курса", example = "Компьютерная логика")
    private String  courseName;

    @ApiModelProperty(notes = "Описание курса", example = "Для студентов 2-го курса технических специальностей")
    private String  courseDescription;

    @ApiModelProperty(notes = "*Название курса*", example = "xxxxxxx")
    private String  tmpCourseName;

}

