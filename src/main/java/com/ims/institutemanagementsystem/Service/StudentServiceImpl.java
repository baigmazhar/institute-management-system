package com.ims.institutemanagementsystem.Service;

import com.ims.institutemanagementsystem.Entity.Student;
import com.ims.institutemanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<List<Student>> getAllStudents(){
        if(studentRepository.getAllStudent().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
           return ResponseEntity.ok(studentRepository.getAllStudent());
        }
    }

    @Override
    public ResponseEntity<Student> getStudent(int studentId) {
        List<Student> students = studentRepository.getAllStudent();
        Optional<Student> std = students.stream().filter(student -> student.getId() == studentId).findAny();
        if(std.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(std.get());
        }
    }

    @Override
    public ResponseEntity<List<Student>> updateStudent(Student student) {
        List<Student> students = studentRepository.getAllStudent();

        return ResponseEntity.ok(students.stream().map(student1 -> {
            if (student1.getId() == student.getId()) {
                student1.setId(student.getId());
                student1.setName(student.getName());
                student1.setSalary(student.getSalary());
            }
            return student1;
        }).collect(Collectors.toList()));
    }
}
