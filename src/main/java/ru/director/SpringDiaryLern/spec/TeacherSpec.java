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
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
@Component
public class TeacherSpec implements Specification<Teacher> {

    public String key;
    public Object value;
    public String operation;

    @Override
    public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

            if (this.getOperation().equals(":")) {
                predicates.add(criteriaBuilder.equal(
                        root.get(this.getKey()), this.getValue()));
            }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }

    public Specification<Teacher> tolyanLoh(final String name) {
        return (root, query, builder)
                -> builder.or(builder.in(root.get("name")).value(name));
    }

    public Specification<Teacher> listLohov(final List<String> names){
        return (root, query, builder)
                -> builder.or(builder.in(root.get("name")).value(names));

    }


}

