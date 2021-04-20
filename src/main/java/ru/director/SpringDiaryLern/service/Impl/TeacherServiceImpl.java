package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.TeacherRepos;
import ru.director.SpringDiaryLern.service.TeacherService;
import ru.director.SpringDiaryLern.utils.TeacherMappingUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    private final TeacherRepos teacherRepos;
    private final TeacherMappingUtil teacherMappingUtil;

    @Autowired
    public TeacherServiceImpl(TeacherRepos teacherRepos, TeacherMappingUtil teacherMappingUtil) {
        this.teacherRepos = teacherRepos;
        this.teacherMappingUtil = teacherMappingUtil;
    }

    @Override
    public TeacherDto getById(Long id) throws SQLException {
        return teacherMappingUtil.mapToTeacherDto(
                teacherRepos.getById(id)
        );
    }

    @Override
    public List<TeacherDto> findAll() throws SQLException {
        List<TeacherDto> teachersDto = new ArrayList<>();
        List<Teacher> teachers = teacherRepos.findAll();
        for (Teacher teacher : teachers) {
            Long id = teacher.getId();
            TeacherDto teacherDto = teacherMappingUtil.mapToTeacherDto(
                    teacherRepos.getById(id));
            teachersDto.add(teacherDto);
        }
        return teachersDto;
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepos.save(teacher);
    }


    @Override
    public List<TeacherDto> findTeacherByName(String name) throws SQLException {
        List<TeacherDto> listDto = new ArrayList<>();
        List<Teacher> teachersList = teacherRepos.findTeacherByName(name);
        for (Teacher teacher : teachersList) {
            Long id = teacher.getId();
            TeacherDto teacherDto = teacherMappingUtil.mapToTeacherDto(
                    teacherRepos.getById(id));
            listDto.add(teacherDto);
        }
        return listDto;
    }
}
