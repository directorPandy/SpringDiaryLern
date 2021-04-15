package ru.director.SpringDiaryLern.service;

import ru.director.SpringDiaryLern.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher getById(Long id);

    List<Teacher> findAll();

    void save(Teacher teacher);

}
