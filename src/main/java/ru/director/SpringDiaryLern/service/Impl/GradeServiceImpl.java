package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.repos.GradeRepos;
import ru.director.SpringDiaryLern.service.GradeService;
import ru.director.SpringDiaryLern.utils.GradeMappingUtil;

import java.sql.SQLException;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepos gradeRepos;
    private final GradeMappingUtil mappingUtil;


    @Autowired
    public GradeServiceImpl(GradeRepos gradeRepos, GradeMappingUtil mappingUtil) {
        this.gradeRepos = gradeRepos;
        this.mappingUtil = mappingUtil;
    }


    @Override
    public GradeDto getById(Long id) throws SQLException {
        return mappingUtil.mapToGradeDto(
                gradeRepos.getById(id)
        );
    }

    @Override
    public List<GradeDto> getAll() {
        return null;
    }

    @Override
    public void save(Grade grade) {
        gradeRepos.save(grade);
    }
}
