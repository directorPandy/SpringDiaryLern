package ru.director.SpringDiaryLern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.director.SpringDiaryLern.connectionControllers.ConnectionModule;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.service.GradeService;
import ru.director.SpringDiaryLern.service.StudentService;
import ru.director.SpringDiaryLern.service.TeacherService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringDiaryLernApplication {

	private static StudentService studentService;
	private static GradeService gradeService;
	private static TeacherService teacherService;


	@Autowired
	public SpringDiaryLernApplication(GradeService gradeService, StudentService studentService, TeacherService teacherService) {
		this.gradeService = gradeService;
		this.studentService = studentService;
		this.teacherService = teacherService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDiaryLernApplication.class,args);

		Grade grade = new Grade("lohi");
		gradeService.save(grade);

		Student misha = new Student("misha", grade);
		Student vasya = new Student("vasya", grade);
		studentService.save(misha);
		studentService.save(vasya);

		List<Student> students = Arrays.asList(misha, vasya);
		grade.setStudents(students);
		gradeService.save(grade);

		Teacher maryJuanna = new Teacher("maryJuanna", grade);
		teacherService.save(maryJuanna);


	}
}
