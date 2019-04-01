package ru.sevsu.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    @NonNull
    @ApiModelProperty(notes = "Фамилия Имя Отчество студента", example = "Petrov V. A.")
    private String     fio;

    @ApiModelProperty(notes = "Номер группы, в которой учится студент", example = "42")
    private Short      grpNum;

    @ApiModelProperty(value = "Стипендия студента", example = "3500")
    private BigDecimal grants;

    @ApiModelProperty(value = "Номер профиля обучения ", example = "22")
    private Integer    profNum;
}
