package ru.director.SpringDiaryLern;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.director.SpringDiaryLern.dto.TeacherDto;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.GradeRepos;
import ru.director.SpringDiaryLern.repos.StudentRepos;
import ru.director.SpringDiaryLern.repos.TeacherRepos;

import ru.director.SpringDiaryLern.utils.TeacherMappingUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@SpringBootTest
@ContextConfiguration
class ReposTest {


	@Autowired
	private TeacherRepos teacherRepos;

	@Autowired
	private StudentRepos studentRepos;

	@Autowired
	private GradeRepos gradeRepos;

	@Autowired
	private TeacherMappingUtil teacherMappingUtil;

	@Test
	void reposTest() {
		teacherRepos.findAll().forEach(
				e -> teacherRepos.save(e));
		gradeRepos.deleteAll();
		teacherRepos.deleteAll();
		studentRepos.deleteAll();
		Grade grade = new Grade("USSR");
		gradeRepos.save(grade);
		Student misha = new Student("lenin", grade);
		Student vasya = new Student("stalin", grade);
		studentRepos.save(misha);
		studentRepos.save(vasya);
		gradeRepos.save(grade);
		Grade grade1 = new Grade("US");
		gradeRepos.save(grade1);
		Student petro = new Student("WASHINGTON", grade1);
		Student shelma = new Student("LINCOLN", grade1);
		studentRepos.save(petro);
		studentRepos.save(shelma);
		gradeRepos.save(grade1);
		Teacher maryJuanna = new Teacher("Mary", grade);
		Teacher marySemenna = new Teacher("Anna", grade1);
		Teacher maryVasillevna = new Teacher("Vika", grade1);
		teacherRepos.save(maryJuanna);
		teacherRepos.save(marySemenna);
		teacherRepos.save(maryVasillevna);

		Assertions.assertEquals("Mary", maryJuanna.getName());
		Assertions.assertEquals(grade.getId(), maryJuanna.getGrade().getId());
		Assertions.assertEquals(grade.getName(),maryJuanna.getGrade().getName());

	}

	@Test
	void testTeacherDto() throws IOException, SQLException {

		TeacherDto teacherDto;
		List<Student> students= new ArrayList<>();

		Grade grade = new Grade("Zalupko", students);
		gradeRepos.save(grade);
		Student skuter = new Student("Skuter", grade);
		studentRepos.save(skuter);
		students.add(skuter);
		grade.setStudents(students);
		gradeRepos.save(grade);
		Teacher teacher = new Teacher("Alla", grade);
		teacherRepos.save(teacher);
		teacherDto = teacherMappingUtil.mapToTeacherDto(teacher);

		Assertions.assertEquals("Zalupko", teacherDto.getGrade().getName());
		Assertions.assertEquals("Alla", teacherDto.getName());

	}
}


