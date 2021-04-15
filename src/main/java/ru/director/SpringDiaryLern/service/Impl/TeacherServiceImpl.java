package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.TeacherRepos;
import ru.director.SpringDiaryLern.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherRepos teacherRepos;

    @Autowired
    public TeacherServiceImpl(TeacherRepos teacherRepos) {
        this.teacherRepos = teacherRepos;
    }

    @Override
    public Teacher getById(Long id) {
        return teacherRepos.findById(id).get();
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepos.findAll();
    }

    @Override
    public void save(Teacher teacher) { teacherRepos.save(teacher); }
}
