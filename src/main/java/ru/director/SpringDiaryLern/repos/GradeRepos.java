package ru.director.SpringDiaryLern.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.director.SpringDiaryLern.model.Grade;



public interface GradeRepos extends JpaRepository<Grade, Long> {

    @Query("select s from Grade s where s.name like %?1%")
    Page<Grade> findGradeByName(String name,Pageable pageable);

    Page<Grade> findAll(Pageable pageable);

}
