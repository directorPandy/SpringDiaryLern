package ru.director.SpringDiaryLern.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.director.SpringDiaryLern.model.Teacher;

public interface TeacherRepos extends JpaRepository<Teacher, Long>  {
}
