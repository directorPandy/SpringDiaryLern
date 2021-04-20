package ru.director.SpringDiaryLern.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.model.Teacher;

import java.util.List;

public interface TeacherRepos extends JpaRepository<Teacher, Long>  {

    @Query("select s from Teacher s where name like %?1%")
    List<Teacher> findTeacherByName(String name);

}
