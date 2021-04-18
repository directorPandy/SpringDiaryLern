package ru.director.SpringDiaryLern.dto;

import lombok.Data;
import java.util.List;

@Data
public class GradeDto {


    Long id;
    String name;
    public List<String> studentsNames;

}
