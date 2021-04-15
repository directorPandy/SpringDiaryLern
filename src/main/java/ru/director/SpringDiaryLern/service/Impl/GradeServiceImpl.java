package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.repos.GradeRepos;
import ru.director.SpringDiaryLern.service.GradeService;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepos gradeRepos;

    @Autowired
    public GradeServiceImpl(GradeRepos gradeRepos) {
        this.gradeRepos = gradeRepos;
    }

    @Override
    public Grade getById(Long id) {
        return gradeRepos.findById(id).get();
    }

    @Override
    public List<Grade> getAll() {
        return gradeRepos.findAll();
    }

    @Override
    public void save(Grade grade){
        gradeRepos.save(grade); }

}
