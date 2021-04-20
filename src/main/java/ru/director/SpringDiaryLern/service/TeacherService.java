package ru.director.SpringDiaryLern.service;

import org.springframework.data.domain.Pageable;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {

    TeacherDto getById(Long id) throws SQLException;

    List<TeacherDto> findAll() throws SQLException;

    void save(Teacher teacher);

    List<TeacherDto> findTeacherByName(String name) throws SQLException;



}
