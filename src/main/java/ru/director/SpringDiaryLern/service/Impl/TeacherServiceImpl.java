package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.TeacherRepos;
import ru.director.SpringDiaryLern.service.TeacherService;
import ru.director.SpringDiaryLern.utils.TeacherMappingUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {


    private final TeacherRepos teacherRepos;
    private final TeacherMappingUtil teacherMappingUtil;

    @Autowired
    public TeacherServiceImpl(TeacherRepos teacherRepos, TeacherMappingUtil teacherMappingUtil) {
        this.teacherRepos = teacherRepos;
        this.teacherMappingUtil = teacherMappingUtil;
    }

    @Override
    public TeacherDto getById(Long id) throws SQLException, IOException {
        return teacherMappingUtil.mapToTeacherDto(
                teacherRepos.getById(id)
        );
    }

    @Override
    public Page<TeacherDto> findAll(Specification specification, Pageable pageable) throws SQLException, IOException {
        List<TeacherDto> teachersDto = new ArrayList<>();
        Page<Teacher> teachers = teacherRepos.findAll(specification, pageable);
        return getTeacherDto(teachersDto, teachers);
    }

    private Page<TeacherDto> getTeacherDto(List<TeacherDto> teachersDto, Page<Teacher> teachers) throws SQLException, IOException {
        for (Teacher teacher : teachers) {
            Long id = teacher.getId();
            TeacherDto teacherDto = teacherMappingUtil.mapToTeacherDto(
                    teacherRepos.getById(id));
            teachersDto.add(teacherDto);
        }
        return new PageImpl<>(teachersDto);
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepos.save(teacher);
    }

    @Override
    public Page<TeacherDto> findTeacherByName(Specification specification, Pageable pageable) throws SQLException, IOException {
        List<TeacherDto> listDto = new ArrayList<>();
        Page<Teacher> teachersList = teacherRepos.findAll(specification, pageable);
        return getTeacherDto(listDto, teachersList);
    }

    @Override
    public Teacher findTeacherByNamewWthtDto(String name){
        return teacherRepos.findTeacherByName(name);
    }
}
