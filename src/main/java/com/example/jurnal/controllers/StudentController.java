package com.example.jurnal.controllers;

import com.example.jurnal.models.Student;
import com.example.jurnal.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service){this.service = service;}

    @GetMapping()
    public String index (Model model){
        model.addAttribute("student", service.showAvailableStudent());
        return "student/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student",service.findById(id));
        return "student/show";
    }

    @GetMapping("/new")
    public String newStudent (Model model){
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @GetMapping("/showGrades")
    public String studentsGrade(Model model) {
        model.addAttribute("student", service.studentsGrade());
        return "student/show_grade";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") Student student){
        service.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", service.findById(id));
        return "student/edit";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, @PathVariable("id") Long id) {
        if(bindingResult.hasErrors()){
            return "sudent/edit";
        }
        service.update(id,student);
        return "redirect:/student";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/student";
    }
}