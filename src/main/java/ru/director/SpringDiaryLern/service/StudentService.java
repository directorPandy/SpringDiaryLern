package ru.director.SpringDiaryLern.service;

import ru.director.SpringDiaryLern.model.Student;

import java.util.List;

public interface StudentService {

    Student getById(Long id);

    List<Student> getAll();

    void save(Student student);

}
