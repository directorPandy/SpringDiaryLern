package ru.director.SpringDiaryLern.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.service.GradeService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;


@Service
@Transactional
public class TeacherMappingUtil {


    private GradeService gradeService;

    @Autowired
    public TeacherMappingUtil(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public TeacherDto mapToTeacherDto(Teacher teacher) throws SQLException, IOException {

        Long id;
        id = teacher.getGrade().getId();
        TeacherDto dto = new TeacherDto();
        GradeDto grade = gradeService.getById(id);

        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setGrade(grade);

        return dto;
    }
}




