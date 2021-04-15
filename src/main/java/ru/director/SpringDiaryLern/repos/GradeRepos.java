package ru.director.SpringDiaryLern.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.director.SpringDiaryLern.model.Grade;

public interface GradeRepos extends JpaRepository<Grade, Long> {
}
