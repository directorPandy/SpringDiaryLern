package ru.director.SpringDiaryLern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Proxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestParam;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.GradeRepos;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.repos.TeacherRepos;
import ru.director.SpringDiaryLern.service.Impl.GradeServiceImpl;
import ru.director.SpringDiaryLern.service.Impl.StudentServiceImpl;
import ru.director.SpringDiaryLern.service.Impl.TeacherServiceImpl;
import ru.director.SpringDiaryLern.utils.TeacherMappingUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"ru.director.SpringDiaryLern"})
@ContextConfiguration(classes = {TeacherServiceImpl.class})
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = SpringDiaryLernApplication.class)
@AutoConfigureMockMvc

public class TeacherRestControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GradeServiceImpl gradeService;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private TeacherRepos teacherRepos;

    @Autowired
    private StudentRepos studentRepos;

    @Autowired
    private GradeRepos gradeRepos;

    @MockBean
    private TeacherServiceImpl teacherService;

    @Autowired
    private TeacherMappingUtil teacherMappingUtil;


    @Transactional
    @Test
    public void givenTeachers_wheGet_ReturnJson()
        throws Exception {

        Teacher teacher = new Teacher("teacher");
        Grade grade = new Grade("grade");
        gradeRepos.save(grade);
        Student student = new Student("student");
        studentRepos.save(student);
        List<Student> students = new ArrayList<>();
        student.setGrade(grade);
        studentRepos.save(student);
        students.add(student);
        grade.setStudents(students);
        gradeRepos.save(grade);
        teacher.setGrade(grade);
        teacherRepos.save(teacher);

        TeacherDto teacherDto = teacherMappingUtil.mapToTeacherDto(
                teacherRepos.getById(teacher.getId()));

        when(this.teacherService.getById(teacher.getId())).thenReturn(teacherDto);

        mockMvc.perform(get("/api/v1/teachers/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(teacher.getName()));

    }
}
