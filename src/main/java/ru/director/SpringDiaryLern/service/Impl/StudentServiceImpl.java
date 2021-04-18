package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.service.StudentService;
import ru.director.SpringDiaryLern.utils.StudentMappingUtil;
import java.sql.SQLException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepos studentRepos;
    private final StudentMappingUtil studentMappingUtil;


    @Autowired
    public StudentServiceImpl(StudentRepos studentRepos, StudentMappingUtil studentMappingUtil) {
        this.studentRepos = studentRepos;
        this.studentMappingUtil = studentMappingUtil;
    }

    @Override
    public StudentDto getById(Long id) throws SQLException {
        return studentMappingUtil.mapToStudentDto(
                studentRepos.getById(id)
        );
    }

    @Override
    public List<Student> getAll() {
        return studentRepos.findAll();
    }

    @Override
    public void save(Student student) { studentRepos.save(student);

    }
}
