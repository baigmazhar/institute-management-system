package com.ims.institutemanagementsystem.Controller;

import com.ims.institutemanagementsystem.Entity.Student;
import com.ims.institutemanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/test")
    public  String testMethod(){
        return "Working";
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId){
    return this.studentService.getStudent(studentId);
    }

    @PostMapping("/updateStudent")
    public ResponseEntity<List<Student>> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
}
