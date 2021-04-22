package ru.director.SpringDiaryLern.utils;


import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dao.GradeDao;
import ru.director.SpringDiaryLern.dao.StudentDao;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Student;


import java.sql.SQLException;

@Service
public class StudentMappingUtil {

    Long gradeId;

    public StudentDto mapToStudentDto(Student student) throws SQLException {

        StudentDto dto = new StudentDto();
        StudentDao studentDao = new StudentDao(student);

        gradeId = studentDao.getStudentGrade();
        GradeDao gradeDao = new GradeDao(gradeId);

        dto.setId(student.getId());
        dto.setName(student.getName());

        dto.setGradeName(gradeDao.getGradeName());

        return dto;
    }
}
