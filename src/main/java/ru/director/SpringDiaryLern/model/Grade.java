package ru.director.SpringDiaryLern.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name="Grade")
@Table(name="grade")
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue
    @Column(name = "id",
            updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Student> students;

    String studentName;

    public Grade(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Grade(String name) {
        this.name = name;
    }

    public Grade() {
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

