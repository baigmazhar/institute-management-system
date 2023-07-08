package com.ims.institutemanagementsystem.Service;

import com.ims.institutemanagementsystem.Entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    public ResponseEntity<List<Student>> getAllStudents();

    public ResponseEntity<Student> getStudent(int studentId);

    public ResponseEntity<List<Student>> updateStudent(Student student);
}
