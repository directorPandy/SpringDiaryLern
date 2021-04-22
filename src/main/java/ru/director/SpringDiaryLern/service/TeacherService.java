package ru.director.SpringDiaryLern.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;
import java.io.IOException;
import java.sql.SQLException;


public interface TeacherService {

    TeacherDto getById(Long id) throws SQLException, IOException;

    Page<TeacherDto> findAll(Pageable pageable) throws SQLException, IOException;

    void save(Teacher teacher);

    Page<TeacherDto> findTeacherByName(String name, Pageable pageable) throws SQLException, IOException;



}
