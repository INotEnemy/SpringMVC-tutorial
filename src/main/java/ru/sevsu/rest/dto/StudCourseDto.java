package ru.sevsu.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudCourseDto {

    @NonNull
    @ApiModelProperty(notes = "Фамилия Имя Отчество студента", example = "Petrov V. A.")
    private String studName;

    @NonNull
    @ApiModelProperty(notes = "Название курса", example = "Компьютерная логика")
    private String courseName;

}
