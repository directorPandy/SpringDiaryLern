package ru.director.SpringDiaryLern.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.director.SpringDiaryLern.model.Grade;





public interface GradeRepos extends JpaRepository<Grade, Long>, JpaSpecificationExecutor<Grade> {

    Page<Grade> findAll(Specification specification, Pageable pageable);

}
