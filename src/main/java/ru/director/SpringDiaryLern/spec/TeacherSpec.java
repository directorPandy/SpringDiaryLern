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

    public List<SearchCriteria> list;

    public TeacherSpec() {
        this.list = new ArrayList<>();
    }

    public void add(SearchCriteria searchCriteria) {
        list.add(searchCriteria);
    }


    @Override
    public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : list) {
            if (criteria.getOperation().equals(":")) {
                predicates.add(criteriaBuilder.equal(
                        root.get(criteria.getKey()), criteria.getValue()));
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}