package ru.director.SpringDiaryLern.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.director.SpringDiaryLern.model.Student;
import ru.director.SpringDiaryLern.model.Teacher;


public interface TeacherRepos extends JpaRepository<Teacher, Long>  {

    Page<Teacher> findAll(Specification specification, Pageable pageable);

    @Query("select s from Teacher s where s.name like %?1%")
    Teacher findTeacherByName(String name);

}
