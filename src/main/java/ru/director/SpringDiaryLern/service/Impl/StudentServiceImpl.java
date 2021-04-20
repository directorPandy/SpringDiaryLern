package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<StudentDto> findAll() throws SQLException {
        List<StudentDto> studentsDto = new ArrayList<>();
        List<Student> students = studentRepos.findAll();
        for (Student student: students) {
            Long id = student.getId();
            studentsDto.add(studentMappingUtil.mapToStudentDto(
                    studentRepos.getById(id)));
        } return studentsDto;
    }

    @Override
    public void save(Student student) { studentRepos.save(student);
    }

    @Override
    public List<StudentDto> findStudentByName(String name) throws SQLException {
        List<StudentDto> listDto = new ArrayList<>();
        List<Student> studentList = studentRepos.findStudentByName(name);
        for(Student student:studentList){
            Long id = student.getId();
            StudentDto studentDto = studentMappingUtil.mapToStudentDto(
                    studentRepos.getById(id));
            listDto.add(studentDto);
        }return  listDto;
    }
}
