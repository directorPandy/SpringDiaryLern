package ru.director.SpringDiaryLern.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;

import java.sql.SQLException;
import java.util.List;

public interface GradeService {

    GradeDto getById(Long id) throws SQLException;

    List<GradeDto> findAll() throws SQLException;

    void save(Grade grade);

    List<GradeDto> findByName(String name) throws SQLException;

}
