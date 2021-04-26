package ru.director.SpringDiaryLern.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.service.TeacherService;
import ru.director.SpringDiaryLern.spec.GradeSpec;
import ru.director.SpringDiaryLern.spec.SearchCriteria;
import ru.director.SpringDiaryLern.spec.SearchOperation;
import ru.director.SpringDiaryLern.spec.TeacherSpec;

import java.io.IOException;
import java.sql.SQLException;


@RestController
@RequestMapping("api/v1/teachers/")
public class TeacherRestController {

    TeacherService teacherService;

    @Autowired
    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable("id") Long teacherId) throws SQLException, IOException {
        TeacherDto teacher = this.teacherService.getById(teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @RequestMapping(value = "saveTeacher", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
        this.teacherService.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @RequestMapping(value = "allTeachers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<TeacherDto>> findAllStudents(
            @PageableDefault()
                    Pageable pageable) throws SQLException, IOException {
        Page<TeacherDto> list =   this.teacherService.findAll(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value="findTeacher", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<TeacherDto>> findTeacherByName(@RequestParam String name, Pageable pageable) throws SQLException, IOException {
        TeacherSpec teacherSpec = new TeacherSpec("name", name, ":");
        Page<TeacherDto> list = this.teacherService.findTeacherByName(teacherSpec, pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
