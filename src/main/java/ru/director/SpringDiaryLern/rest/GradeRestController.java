package ru.director.SpringDiaryLern.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.service.GradeService;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/grades/")
public class GradeRestController {

    private GradeService gradeService;

    @Autowired
    public GradeRestController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GradeDto> getGrade(@PathVariable("id") Long gradeId) throws SQLException {
        GradeDto grade = this.gradeService.getById(gradeId);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @RequestMapping(value="saveGrade", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade){
        this.gradeService.save(grade);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }
}
