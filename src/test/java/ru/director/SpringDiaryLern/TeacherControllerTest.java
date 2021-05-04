package ru.director.SpringDiaryLern;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.model.Teacher;

import ru.director.SpringDiaryLern.service.GradeService;
import ru.director.SpringDiaryLern.service.StudentService;
import ru.director.SpringDiaryLern.service.TeacherService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SpringDiaryLernApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class TeacherControllerTest {


    @Autowired
    private GradeService gradeService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReturn200() throws Exception {

        Grade grade3 = new Grade("SHARAGA");
        gradeService.save(grade3);
        Student larin = new Student("LARIN", grade3);
        studentService.save(larin);
        List<Student> students3 = Arrays.asList(larin);
        grade3.setStudents(students3);
        gradeService.save(grade3);
        Teacher burpul = new Teacher("MISS BURPUL", grade3);
        teacherService.save(burpul);


        mockMvc.perform(get("/api/v1/teachers/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(burpul.getName()));
        System.out.println("Test Passed");

        mockMvc.perform(get("/api/v1/teachers/allTeachers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content[0].name").value(burpul.getName()));
        System.out.println("Test Passed");
    }
}
