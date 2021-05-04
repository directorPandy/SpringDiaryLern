package ru.director.SpringDiaryLern.utils;

import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dao.StudentDao;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;


import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GradeMappingUtil {

    List<Student> students = new ArrayList<>();

    public GradeDto mapToGradeDto(Grade grade) throws SQLException {

        GradeDto dto = new GradeDto();
        StudentDao studentDao = new StudentDao(students = grade.getStudents());

        dto.setId(grade.getId());
        dto.setName(grade.getName());

        dto.studentsNames = studentDao.getStudentNames();

        return dto;
    }

}
