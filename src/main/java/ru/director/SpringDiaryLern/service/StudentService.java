package ru.director.SpringDiaryLern.service;

import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    StudentDto getById(Long id) throws SQLException;

    List<StudentDto> findAll() throws SQLException;

    void save(Student student);

    List<StudentDto> findStudentByName(String name) throws SQLException;

}
