package com.springboot.teacherCrud.controller;

import com.springboot.teacherCrud.entity.Teacher;
import com.springboot.teacherCrud.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService theTeacherService) {
        teacherService = theTeacherService;
    }
    
    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String listTeachers(Model theModel) {
        // get teachers from db
        List<Teacher> theTeachers = teacherService.findAll();

        // add to the spring model
        theModel.addAttribute("teachers", theTeachers);

        return "teachers/list-teachers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Teacher theTeacher = new Teacher();

        theModel.addAttribute("teacher", theTeacher);

        return "teachers/teacher-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("teacherId") int theId, Model theModel) {
        // get the teacher from the service
        Teacher theTeacher = teacherService.findById(theId);

        // set teacher as a model attribute to pre-populate the form
        theModel.addAttribute("teacher", theTeacher);

        return "teachers/teacher-form";
    }

    @PostMapping("/save")
    public String saveTeacher(@Valid @ModelAttribute("teacher") Teacher theTeacher, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "teachers/teacher-form";
        }
        
        // save the teacher
        teacherService.save(theTeacher);

        // use a redirect to prevent duplicate submissions
        return "redirect:/teachers/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("teacherId") int theId) {
        // delete the teacher
        teacherService.deleteById(theId);

        // redirect to /teachers/list
        return "redirect:/teachers/list";
    }
}
