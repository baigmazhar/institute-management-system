package com.ims.institutemanagementsystem.Service;

import com.ims.institutemanagementsystem.Entity.Student;
import com.ims.institutemanagementsystem.Exception.StudentNotFoundException;
import com.ims.institutemanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<List<Student>> getAllStudents(){
        if(studentRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
           return ResponseEntity.ok(studentRepository.findAll());
        }
    }

    public ResponseEntity<String> saveStudent(Student student){
        try{
            studentRepository.save(student);
            System.out.println("Student saved successfully");
        }catch (Exception err){
            System.out.println(err);
        }


        return null;
    }

    @Override
    public Optional<Student> getStudent(Integer studentId) {
        Optional<Student> students = studentRepository.findById(studentId);
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        try{
        studentRepository.updateStudent(student.getId(), student.getName(), student.getSalary());
        }catch (Exception err){
            System.out.println(err);
        }

    }

    @Override
    public ResponseEntity<String> deleteStudent(Integer id){
        try {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student having id "+ id + " successfully deleted.");
        } catch (Exception e) {
            throw new StudentNotFoundException(e.getMessage());
        }
    }
}
