package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.StudentDto;
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
    public Page<TeacherDto> findAll(Pageable pageable) throws SQLException {
        List<TeacherDto> teachersDto = new ArrayList<>();
        Page<Teacher> teachers = teacherRepos.findAll(pageable);
        return getTeacherDtos(teachersDto, teachers);
    }

    private Page<TeacherDto> getTeacherDtos(List<TeacherDto> teachersDto, Page<Teacher> teachers) throws SQLException {
        for (Teacher teacher : teachers) {
            Long id = teacher.getId();
            TeacherDto teacherDto = teacherMappingUtil.mapToTeacherDto(
                    teacherRepos.getById(id));
            teachersDto.add(teacherDto);
        }
        Page<TeacherDto> page= new PageImpl<>(teachersDto);
        return page;
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepos.save(teacher);
    }


    @Override
    public Page<TeacherDto> findTeacherByName(String name, Pageable pageable) throws SQLException {
        List<TeacherDto> listDto = new ArrayList<>();
        Page<Teacher> teachersList = teacherRepos.findTeacherByName(name, pageable);
        return getTeacherDtos(listDto, teachersList);
    }
}
