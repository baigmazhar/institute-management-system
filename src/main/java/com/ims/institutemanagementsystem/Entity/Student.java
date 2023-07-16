package com.ims.institutemanagementsystem.Entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;
    String name;

    Integer salary;

    public Student(){}
    public Student(String name, Integer id, Integer salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
