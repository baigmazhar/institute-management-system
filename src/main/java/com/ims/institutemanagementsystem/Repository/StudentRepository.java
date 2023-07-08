package com.ims.institutemanagementsystem.Repository;

import com.ims.institutemanagementsystem.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    public List<Student> getAllStudent(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Saad", 101, 10000));
        studentList.add(new Student("Fatema", 102, 7000));
        studentList.add(new Student("Arham", 103, 8000));
        studentList.add(new Student("Maryam", 104, 9000));
        studentList.add(new Student("Zainab", 105, 5000));
        return studentList;
    }
}
