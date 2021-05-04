package ru.director.SpringDiaryLern.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Student;

import java.io.IOException;
import java.sql.SQLException;

@Service
public interface StudentService {

    StudentDto getById(Long id) throws SQLException, IOException;

    Page<StudentDto> findAll(Pageable pageable) throws SQLException, IOException;

    void save(Student student);

    Page<StudentDto> findStudentByName(String name, Pageable pageable) throws SQLException, IOException;

}
