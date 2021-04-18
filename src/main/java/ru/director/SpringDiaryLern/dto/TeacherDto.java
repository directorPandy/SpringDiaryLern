package ru.director.SpringDiaryLern.dto;

import lombok.Data;
import ru.director.SpringDiaryLern.model.Grade;


@Data
public class TeacherDto {

    Long id;
    String name;
    GradeDto grade;

}
