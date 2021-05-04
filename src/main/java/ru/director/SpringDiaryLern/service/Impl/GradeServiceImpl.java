package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.spec.GradeSpec;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.repos.GradeRepos;
import ru.director.SpringDiaryLern.service.GradeService;
import ru.director.SpringDiaryLern.utils.GradeMappingUtil;


import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

    private final GradeRepos gradeRepos;
    private final GradeMappingUtil mappingUtil;
    private final GradeSpec gradeSpec;


    @Autowired
    public GradeServiceImpl(GradeSpec gradeSpec,GradeRepos gradeRepos, GradeMappingUtil mappingUtil) {
        this.gradeRepos = gradeRepos;
        this.mappingUtil = mappingUtil;
        this.gradeSpec = gradeSpec;
    }


    @Override
    public GradeDto getById(Long id) throws SQLException, IOException {
        return mappingUtil.mapToGradeDto(
                gradeRepos.getById(id)
        );
    }

    @Override
    public Page<GradeDto> findAll(Pageable pageable) throws SQLException, IOException {
        List<GradeDto> listDto = new ArrayList<>();
        Page<Grade> list = gradeRepos.findAll(pageable);
        return getGradeDto(listDto, list);
    }

    private Page<GradeDto> getGradeDto(List<GradeDto> listDto, Page<Grade> list) throws SQLException {
        for(Grade grade:list){
            Long id = grade.getId();
            GradeDto gradeDto1 = mappingUtil.mapToGradeDto(
                    gradeRepos.getById(id));
            listDto.add(gradeDto1);
        }
        return new PageImpl<>(listDto);
    }

    @Override
    public void save(Grade grade) {
        gradeRepos.save(grade);
    }

    @Override
    public Page<GradeDto> findGradeByName(Specification<Grade> specification, Pageable pageable) throws SQLException {
        List<GradeDto> listDto = new ArrayList<>();
        Page<Grade> gradesList = gradeRepos.findAll(specification, pageable);
        return getGradeDto(listDto, gradesList);
    }

}
