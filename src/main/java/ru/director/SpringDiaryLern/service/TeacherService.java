package ru.director.SpringDiaryLern.service;

import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {

    TeacherDto getById(Long id) throws SQLException;

    List<Teacher> findAll();

    void save(Teacher teacher);

}
