package ru.director.SpringDiaryLern.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.service.StudentService;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentRestController {

    StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) { this.studentService = studentService;}

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long studentId){
        Student student = this.studentService.getById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(value ="saveStudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        this.studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

}

