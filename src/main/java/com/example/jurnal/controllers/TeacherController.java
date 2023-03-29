package com.example.jurnal.controllers;

import com.example.jurnal.models.Teacher;
import com.example.jurnal.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Teacher save(@RequestBody Teacher teacher){
        return service.save(teacher);
    }

    @GetMapping("/findById")
    public Teacher findById(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/findAll")
    public List<Teacher> findAll() {
        return service.findAll();
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        service.delete(id);
        return "success";
    }

}
