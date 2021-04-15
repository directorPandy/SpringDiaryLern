package ru.director.SpringDiaryLern.service;

import ru.director.SpringDiaryLern.model.Grade;

import java.util.List;

public interface GradeService {

    Grade getById(Long id);

    List<Grade> getAll();

    void save(Grade grade);





}
