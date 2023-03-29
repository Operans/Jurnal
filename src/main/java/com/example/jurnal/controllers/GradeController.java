package com.example.jurnal.controllers;

import com.example.jurnal.models.Grade;
import com.example.jurnal.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/grade")
public class GradeController {

    private GradeService services;

    @Autowired
    public GradeController(GradeService services) {
        this.services = services;
    }

    @PostMapping("/save")
    public Grade save(@RequestBody Grade grade) {
        return services.save(grade);
    }

    @GetMapping("/findById")
    public Grade findById(@RequestParam Long id) {
        return services.findById(id);
    }

    @GetMapping("findAll")
    public List<Grade> findAll() {
        return services.findAll();
    }

}
