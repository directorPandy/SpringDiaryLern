package ru.director.SpringDiaryLern.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.director.SpringDiaryLern.model.Student;

public interface StudentRepos extends JpaRepository<Student, Long>  {
}
