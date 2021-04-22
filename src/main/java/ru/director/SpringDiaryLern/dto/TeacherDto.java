package ru.director.SpringDiaryLern.dto;

import lombok.Data;

@Data
public class TeacherDto {

    Long id;
    String name;
    GradeDto grade;

}
