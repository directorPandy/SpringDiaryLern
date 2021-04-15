package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepos studentRepos;

    @Autowired
    public StudentServiceImpl(StudentRepos studentRepos) {
        this.studentRepos = studentRepos;
    }


    @Override
    public Student getById(Long id) { return studentRepos.findById(id).get();
    }

    @Override
    public List<Student> getAll() {
        return studentRepos.findAll();
    }

    @Override
    public void save(Student student) { studentRepos.save(student);

    }
}
