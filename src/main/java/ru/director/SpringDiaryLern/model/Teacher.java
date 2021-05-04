package ru.director.SpringDiaryLern.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import javax.persistence.*;

@Entity(name = "Teacher")
@Table(name = "teacher")
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = "id",
            updatable = false)
    private Long id;

    @Column(name = "name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;


    @OneToOne()
    @JoinColumn(name = "grade_id")
    Grade grade;

    public Teacher(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
