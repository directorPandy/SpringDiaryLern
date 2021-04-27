package ru.director.SpringDiaryLern.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;
import java.io.IOException;
import java.sql.SQLException;


public interface TeacherService {

    TeacherDto getById(Long id) throws SQLException, IOException;

    Page<TeacherDto> findAll(Specification specification, Pageable pageable) throws SQLException, IOException;

    void save(Teacher teacher);

    Page<TeacherDto> findTeacherByName(Specification specification, Pageable pageable) throws SQLException, IOException;



}
