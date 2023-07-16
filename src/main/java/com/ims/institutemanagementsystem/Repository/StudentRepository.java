package com.ims.institutemanagementsystem.Repository;

import com.ims.institutemanagementsystem.Entity.Student;
import com.ims.institutemanagementsystem.Exception.StudentNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public default List<Student> getAllStudent(){
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Saad", 101, 10000));
        studentList.add(new Student("Fatema", 102, 7000));
        studentList.add(new Student("Arham", 103, 8000));
        studentList.add(new Student("Maryam", 104, 9000));
        studentList.add(new Student("Zainab", 105, 5000));
        return studentList;
    }

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.name = ?2, s.salary = ?3 WHERE s.id = ?1")
    void updateStudent(Integer id, String name, Integer salary);


}
