package ru.director.SpringDiaryLern.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;
import java.io.IOException;
import java.sql.SQLException;

@Service
public interface GradeService {

    GradeDto getById(Long id) throws SQLException, IOException;

    Page<GradeDto> findAll(Pageable pageable) throws SQLException, IOException;

    void save(Grade grade);

    Page<GradeDto> findGradeByName(Specification<Grade> specification, Pageable pageable) throws SQLException;
}
