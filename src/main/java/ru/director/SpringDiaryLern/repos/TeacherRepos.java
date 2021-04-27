package ru.director.SpringDiaryLern.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.director.SpringDiaryLern.model.Teacher;



public interface TeacherRepos extends JpaRepository<Teacher, Long>  {

    Page<Teacher> findAll(Specification specification, Pageable pageable);

}
