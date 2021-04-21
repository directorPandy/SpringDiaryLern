package ru.director.SpringDiaryLern.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {

    TeacherDto getById(Long id) throws SQLException;

    Page<TeacherDto> findAll(Pageable pageable) throws SQLException;

    void save(Teacher teacher);

    Page<TeacherDto> findTeacherByName(String name, Pageable pageable) throws SQLException;



}
