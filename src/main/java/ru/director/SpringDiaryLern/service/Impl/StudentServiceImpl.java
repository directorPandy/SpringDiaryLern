package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.service.StudentService;
import ru.director.SpringDiaryLern.utils.StudentMappingUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepos studentRepos;
    private final StudentMappingUtil studentMappingUtil;


    @Autowired
    public StudentServiceImpl(StudentRepos studentRepos, StudentMappingUtil studentMappingUtil) {
        this.studentRepos = studentRepos;
        this.studentMappingUtil = studentMappingUtil;
    }

    @Override
    public StudentDto getById(Long id) throws SQLException, IOException {
        return studentMappingUtil.mapToStudentDto(
                studentRepos.getById(id)
        );
    }

    @Override
    public Page<StudentDto> findAll(Pageable pageable) throws SQLException, IOException {
        List<StudentDto> studentsDto = new ArrayList<>();
        Page<Student> students = studentRepos.findAll(pageable);
        return getStudentsDto(studentsDto, students);
    }


    @Override
    public void save(Student student) {
        studentRepos.save(student);
    }

    private Page<StudentDto> getStudentsDto(List<StudentDto> studentsDto, Page<Student> students) throws SQLException{
        for (Student student : students) {
            Long id = student.getId();
            StudentDto studentDto = studentMappingUtil.mapToStudentDto(
                    studentRepos.getById(id));
            studentsDto.add(studentDto);
        }
        return new PageImpl<>(studentsDto);
    }

    @Override
    public Page<StudentDto> findStudentByName(String name, Pageable pageable) throws SQLException{
        List<StudentDto> listDto = new ArrayList<>();
        Page<Student> studentsList = studentRepos.findStudentByName(name, pageable);
        return getStudentsDto(listDto, studentsList);
    }
}
