package ru.director.SpringDiaryLern.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    StudentDto getById(Long id) throws SQLException;

    Page<StudentDto> findAll(Pageable pageable) throws SQLException;

    void save(Student student);

    Page<StudentDto> findStudentByName(String name, Pageable pageable) throws SQLException;

}
