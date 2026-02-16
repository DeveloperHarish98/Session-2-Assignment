package com.springboot.teacherCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.teacherCrud.entity.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    
    // add a method to sort by last name by default? 
    // Data JPA provides findAllByOrderByLastNameAsc() but for simple CRUD findAll() is enough.
    public List<Teacher> findAllByOrderByLastNameAsc();
}
