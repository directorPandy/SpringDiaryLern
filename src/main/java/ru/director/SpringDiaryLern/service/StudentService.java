package ru.director.SpringDiaryLern.service;

import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    StudentDto getById(Long id) throws SQLException;

    List<Student> getAll();

    void save(Student student);

}
