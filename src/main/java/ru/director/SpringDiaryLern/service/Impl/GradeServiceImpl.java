package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.repos.GradeRepos;
import ru.director.SpringDiaryLern.service.GradeService;
import ru.director.SpringDiaryLern.utils.GradeMappingUtil;


import java.sql.SQLException;
import java.util.ArrayList;
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
    public Page<GradeDto> findAll(Pageable pageable) throws SQLException {
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
    public Page<GradeDto> findByName(String name, Pageable pageable) throws SQLException {
        List<GradeDto> listDto = new ArrayList<>();
        Page<Grade> gradesList = gradeRepos.findGradeByName(name, pageable);
        return getGradeDto(listDto, gradesList);
    }

}
