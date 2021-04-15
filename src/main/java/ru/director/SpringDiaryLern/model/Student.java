package ru.director.SpringDiaryLern.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Student")
@Table(name="student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id",
    updatable = false)
    private Long id;

    @Column(name = "name",
    nullable = false,
    columnDefinition = "TEXT")
    private String name;


    public Student(String name) {
        this.name = name;
    }

    public Student() {

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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
