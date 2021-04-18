package ru.director.SpringDiaryLern.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.TeacherRepos;
import ru.director.SpringDiaryLern.service.TeacherService;
import ru.director.SpringDiaryLern.utils.TeacherMappingUtil;

import java.sql.SQLException;
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
    public List<Teacher> findAll() {
        return teacherRepos.findAll();
    }

    @Override
    public void save(Teacher teacher) { teacherRepos.save(teacher); }
}
