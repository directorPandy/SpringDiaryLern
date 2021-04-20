package ru.director.SpringDiaryLern.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.service.TeacherService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/teachers/")
public class TeacherRestController {

    TeacherService teacherService;

    @Autowired
    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeacherDto> getTeacher(@PathVariable("id") Long teacherId) throws SQLException {
        TeacherDto teacher = this.teacherService.getById(teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @RequestMapping(value = "saveTeacher", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
        this.teacherService.save(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
    @RequestMapping(value = "allTeachers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TeacherDto>> findAllTeachers() throws SQLException {
        List<TeacherDto> list = this.teacherService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value="findTeacher", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedListHolder> findTeacherByName(@RequestParam Optional<String> name) throws SQLException {
        List<TeacherDto> list = this.teacherService.findTeacherByName(name.orElse("_"));
        PagedListHolder page = new PagedListHolder(list);
        page.setPageSize(1);
        page.setPage(1);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

}
