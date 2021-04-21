package ru.director.SpringDiaryLern.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.dto.StudentDto;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.service.StudentService;

import javax.print.attribute.standard.Media;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentRestController {

    StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) { this.studentService = studentService;}

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long studentId) throws SQLException {
        StudentDto student = this.studentService.getById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value ="saveStudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        this.studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "allStudents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<StudentDto>> findAllStudents(Pageable pageable) throws SQLException {
        Page<StudentDto> list =   this.studentService.findAll(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value="findStudent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<StudentDto>> findStudentByName(@RequestParam String name, Pageable pageable) throws SQLException {
        Page<StudentDto> list = this.studentService.findStudentByName(name, pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}

