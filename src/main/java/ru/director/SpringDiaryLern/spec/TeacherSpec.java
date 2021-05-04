package ru.director.SpringDiaryLern.spec;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.director.SpringDiaryLern.model.Teacher;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Data
@Component
public class TeacherSpec implements Specification<Teacher> {

    public String key;
    public Object value;
    public String operation;


    public Specification<Teacher> tolyanLoh(final String name) {
        return (root, query, builder)
                -> builder.or(builder.in(root.get("name")).value(name));
    }

    public Specification<Teacher> listLohov(final List<String> names){
        return (root, query, builder)
                -> builder.or(builder.in(root.get("name")).value(names));

    }

    public Specification<Teacher> vseLohi(){
        return (root, query, builder)
                -> builder.or(builder.in(root.get("name")).value("?"));

    }

    @Override
    public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}

