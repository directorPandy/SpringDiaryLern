package ru.director.SpringDiaryLern.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.director.SpringDiaryLern.model.Teacher;



public interface TeacherRepos extends JpaRepository<Teacher, Long>  {

    @Query("select s from Teacher s where s.name like %?1%")
    Page<Teacher> findTeacherByName(String name, Pageable pageable);

    Page<Teacher> findAll(Pageable pageable);
}
