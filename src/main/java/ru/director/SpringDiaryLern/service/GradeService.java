package ru.director.SpringDiaryLern.service;

import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;

import java.sql.SQLException;
import java.util.List;

public interface GradeService {

    GradeDto getById(Long id) throws SQLException;

    List<GradeDto> getAll();

    void save(Grade grade);

}
