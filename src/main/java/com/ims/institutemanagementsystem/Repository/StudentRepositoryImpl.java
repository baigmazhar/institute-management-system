package com.ims.institutemanagementsystem.Repository;

import com.ims.institutemanagementsystem.Exception.StudentNotFoundException;
import jakarta.persistence.EntityManager;
import org.springframework.dao.DataAccessException;

public abstract class StudentRepositoryImpl implements StudentRepository{
    @Override
    public void updateStudent(Integer id, String name, Integer salary) {
        EntityManager entityManager = null;
        try{
            int affectedRows = entityManager.createQuery("UPDATE Student s SET s.name = ?2, s.email = ?3 WHERE s.id = ?1")
                    .setParameter(1, id)
                    .setParameter(2,name)
                    .setParameter(3,salary).executeUpdate();
            if(affectedRows == 0){
                throw new StudentNotFoundException("Student with ID "+ id +" not found");
            }
        }catch (DataAccessException exception){
            throw new StudentNotFoundException("Error updating student with ID " + id + ".", exception);
        }
    }
}
