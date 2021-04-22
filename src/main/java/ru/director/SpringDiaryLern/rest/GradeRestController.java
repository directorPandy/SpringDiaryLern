package ru.director.SpringDiaryLern.rest;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.service.GradeService;


import java.io.IOException;
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
    public ResponseEntity<GradeDto> getGrade(@PathVariable("id") Long gradeId) throws SQLException, IOException {
        GradeDto grade = this.gradeService.getById(gradeId);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @RequestMapping(value="saveGrade", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade){
        this.gradeService.save(grade);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @RequestMapping(value="allGrades", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<GradeDto>> findAllGrades (
                                                         Pageable pageable) throws SQLException, IOException {
        Page<GradeDto> list = this.gradeService.findAll(pageable);
            return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value="findGrade", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<GradeDto>> findGradeByName(@RequestParam String name, Pageable pageable) throws SQLException, IOException {
        Page<GradeDto> list = this.gradeService.findByName(name, pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
