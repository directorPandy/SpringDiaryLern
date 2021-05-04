package ru.director.SpringDiaryLern;

import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.TeacherRepos;


@RunWith(SpringRunner.class)
@SpringBootTest

public class TeacherRepositoryIntegrationTest {

    @Autowired
    private TeacherRepos teacherRepos;

    @Test
    public void  whenFindByName_thenReturnTeacher(){

        String name = "Vasya";
        Teacher save = teacherRepos.save(new Teacher("Vasya"));
        Assertions.assertThat(name).isEqualTo(save.getName());

    }

}
