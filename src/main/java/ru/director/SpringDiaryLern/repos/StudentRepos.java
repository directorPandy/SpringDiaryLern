package ru.director.SpringDiaryLern.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ru.director.SpringDiaryLern.model.Grade;
import ru.director.SpringDiaryLern.model.Student;

import java.util.List;

public interface StudentRepos extends JpaRepository<Student, Long>  {

    @Query("select s from Student s where name like %?1%")
    List<Student> findStudentByName(String name);

}
