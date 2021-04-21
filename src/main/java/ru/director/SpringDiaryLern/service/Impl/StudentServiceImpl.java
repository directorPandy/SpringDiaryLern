package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.service.StudentService;
import ru.director.SpringDiaryLern.utils.StudentMappingUtil;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public Page<StudentDto> findAll(Pageable pageable) throws SQLException {
        List<StudentDto> studentsDto = new ArrayList<>();
        Page<Student> students = studentRepos.findAll(pageable);
        for (Student student: students) {
            Long id = student.getId();
            studentsDto.add(studentMappingUtil.mapToStudentDto(
                    studentRepos.getById(id)));
        } Page<StudentDto> page = new PageImpl<>(studentsDto);
        return page;
    }

    @Override
    public void save(Student student) { studentRepos.save(student);
    }

    @Override
    public Page<StudentDto> findStudentByName(String name, Pageable Pageable) throws SQLException {
        List<StudentDto> listDto = new ArrayList<>();
        List<Student> studentList = studentRepos.findStudentByName(name);
        for(Student student:studentList){
            Long id = student.getId();
            StudentDto studentDto = studentMappingUtil.mapToStudentDto(
                    studentRepos.getById(id));
            listDto.add(studentDto);
        } Page<StudentDto> page= new PageImpl<>(listDto);
        return  page;
    }
}
