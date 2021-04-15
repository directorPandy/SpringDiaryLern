package ru.director.SpringDiaryLern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.GradeRepos;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.service.GradeService;
import ru.director.SpringDiaryLern.service.StudentService;
import ru.director.SpringDiaryLern.service.TeacherService;

import java.util.ArrayList;
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


		Student misha = new Student("misha");
		Student vasya = new Student("vasya");
		List<Student> students = Arrays.asList(misha, vasya);
		Grade grade = new Grade("lohi", students);
		Teacher maryJuanna = new Teacher("maryJuanna", grade);

		studentService.save(misha);
		studentService.save(vasya);
		gradeService.save(grade);
		teacherService.save(maryJuanna);





	}
}
