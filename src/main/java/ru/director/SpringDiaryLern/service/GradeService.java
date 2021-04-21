package ru.director.SpringDiaryLern.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;

import java.sql.SQLException;
import java.util.List;

public interface GradeService {

    GradeDto getById(Long id) throws SQLException;

    Page<GradeDto> findAll(Pageable pageable) throws SQLException;

    void save(Grade grade);

    Page<GradeDto> findByName(String name, Pageable pageable) throws SQLException;

}
