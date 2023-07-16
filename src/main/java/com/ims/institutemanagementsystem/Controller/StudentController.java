package com.ims.institutemanagementsystem.Controller;

import com.ims.institutemanagementsystem.Entity.Student;
import com.ims.institutemanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Student> getStudent(@PathVariable Integer studentId){
    return this.studentService.getStudent(studentId);
    }

    @PostMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
}
