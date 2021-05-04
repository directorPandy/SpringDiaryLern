package ru.director.SpringDiaryLern;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;
import ru.director.SpringDiaryLern.dto.TeacherDto;

import ru.director.SpringDiaryLern.model.Teacher;
import ru.director.SpringDiaryLern.repos.TeacherRepos;
import ru.director.SpringDiaryLern.service.TeacherService;


import java.io.IOException;
import java.sql.SQLException;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
public class TeacherServiceImpTest {

    @MockBean
    TeacherRepos teacherRepos;

    @Autowired
    TeacherService teacherService;

    @TestConfiguration
    static class TeacherServiceImpTestContextConfiguration {

        @Autowired
        TeacherRepos teacherRepos;

        @Bean
        public TeacherService teacherService() {
            return new TeacherService() {

                @Override
                public TeacherDto getById(Long id) throws SQLException, IOException {
                    return null;
                }
                @Override
                public Page<TeacherDto> findAll(Specification specification, Pageable pageable) throws SQLException, IOException {
                    return null;
                }
                @Override
                public void save(Teacher teacher) {
                }
                @Override
                public Page<TeacherDto> findTeacherByName(Specification specification, Pageable pageable) throws SQLException, IOException {
                    return null;
                }
                @Override
                public Teacher findTeacherByNamewWthtDto(String name) throws SQLException, IOException {
                    return teacherRepos.findTeacherByName(name);
                }
            };
        }
    }

    @Before
    public void setUp(){
        Teacher alex = new Teacher("Alex");
        String name = "Alex";
        teacherService.save(alex);
        Mockito.when(teacherRepos.findTeacherByName(name))
                .thenReturn(alex);
    }

    @Test
    public void whenValidName() throws IOException, SQLException {

        String name = "Alex";
        Teacher found = teacherService.findTeacherByNamewWthtDto(name);

        assertThat(found.getName())
                .isEqualTo(name);
    }
}
