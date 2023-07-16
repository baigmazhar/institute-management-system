package com.ims.institutemanagementsystem.Service;

import com.ims.institutemanagementsystem.Entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public ResponseEntity<List<Student>> getAllStudents();

    public Optional<Student> getStudent(Integer studentId);

    public void updateStudent(Student student);

    ResponseEntity<String> saveStudent(Student student);

    ResponseEntity<String> deleteStudent(Integer id);
}
