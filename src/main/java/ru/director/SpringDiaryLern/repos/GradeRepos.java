package ru.director.SpringDiaryLern.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.director.SpringDiaryLern.dto.GradeDto;
import ru.director.SpringDiaryLern.model.Grade;

import java.util.List;

public interface GradeRepos extends JpaRepository<Grade, Long> {

    @Query("select s from Grade s where name like %?1%")
    List<Grade> findGradeByName(String name);

}
