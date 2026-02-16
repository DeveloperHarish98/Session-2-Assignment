package com.springboot.teacherCrud.service;

import com.springboot.teacherCrud.entity.Teacher;
import com.springboot.teacherCrud.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository theTeacherRepository) {
        teacherRepository = theTeacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Teacher findById(int theId) {
        Optional<Teacher> result = teacherRepository.findById(theId);
        
        Teacher theTeacher = null;
        if (result.isPresent()) {
            theTeacher = result.get();
        } else {
            // we didn't find the teacher
            throw new RuntimeException("Did not find teacher id - " + theId);
        }
        return theTeacher;
    }

    @Override
    public void save(Teacher theTeacher) {
        teacherRepository.save(theTeacher);
    }

    @Override
    public void deleteById(int theId) {
        teacherRepository.deleteById(theId);
    }
}
