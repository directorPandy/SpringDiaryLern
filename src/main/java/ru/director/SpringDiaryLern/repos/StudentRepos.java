package ru.director.SpringDiaryLern.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ru.director.SpringDiaryLern.model.Student;



public interface StudentRepos extends JpaRepository<Student, Long>  {

    @Query("select s from Student s where s.name like %?1%")
    Page<Student> findStudentByName(String name, Pageable pageable);

    Page<Student> findAll(Pageable pageable);

}
