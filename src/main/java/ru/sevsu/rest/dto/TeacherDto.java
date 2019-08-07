package ru.sevsu.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    @NonNull
    @ApiModelProperty(notes = "Фамилия Имя Отчество преподавателя", example = "Fisun V. A.")
    private String     fio;
}
