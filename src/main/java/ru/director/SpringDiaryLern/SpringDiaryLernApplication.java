package ru.director.SpringDiaryLern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ru.director.SpringDiaryLern.model.Credential;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.service.GradeService;
import ru.director.SpringDiaryLern.service.StudentService;
import ru.director.SpringDiaryLern.service.TeacherService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class SpringDiaryLernApplication {

	private static StudentService studentService;
	private static GradeService gradeService;
	private static TeacherService teacherService;





	@Autowired
	public SpringDiaryLernApplication( GradeService gradeService, StudentService studentService, TeacherService teacherService) {
		SpringDiaryLernApplication.gradeService = gradeService;
		SpringDiaryLernApplication.studentService = studentService;
		SpringDiaryLernApplication.teacherService = teacherService;

	}

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SpringDiaryLernApplication.class,args);

		Grade grade = new Grade("USSR");
		gradeService.save(grade);

		Student misha = new Student("lenin", grade);
		Student vasya = new Student("stalin", grade);
		studentService.save(misha);
		studentService.save(vasya);

		List<Student> students = Arrays.asList(misha, vasya);
		grade.setStudents(students);
		gradeService.save(grade);

		Grade grade1 = new Grade("US");
		gradeService.save(grade1);

		Student petro = new Student("WASHINGTON", grade1);
		Student shelma = new Student("LINCOLN", grade1);
		studentService.save(petro);
		studentService.save(shelma);

		List<Student> students1 = Arrays.asList(petro, shelma);
		grade1.setStudents(students1);
		gradeService.save(grade1);

		Teacher maryJuanna = new Teacher("Mary", grade);
		teacherService.save(maryJuanna);

		Teacher marySemenna = new Teacher("Anna", grade1);
		teacherService.save(marySemenna);

		Credential credential = new Credential();
		credential.getCredentials(credential);
		Connection connection = DriverManager.getConnection(credential.getUrl(), credential.getUsername(),
				credential.getPassword());
		System.out.println(connection);
	}
}
