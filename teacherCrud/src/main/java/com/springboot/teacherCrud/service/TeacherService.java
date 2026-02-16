package com.springboot.teacherCrud.service;

import com.springboot.teacherCrud.entity.Teacher;
import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();
    
    Teacher findById(int theId);
    
    void save(Teacher theTeacher);
    
    void deleteById(int theId);
}
