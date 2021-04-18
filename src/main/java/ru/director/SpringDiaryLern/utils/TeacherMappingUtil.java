package ru.director.SpringDiaryLern.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.director.SpringDiaryLern.dao.GradeDao;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.GradeRepos;
import ru.director.SpringDiaryLern.service.GradeService;
import ru.director.SpringDiaryLern.service.Impl.GradeServiceImpl;

import java.sql.SQLException;


@Service
public class TeacherMappingUtil {


    private GradeService gradeService;

    @Autowired
    public TeacherMappingUtil(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public TeacherDto mapToTeacherDto(Teacher teacher) throws SQLException {

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




