package com.example.jurnal.controllers;

import com.example.jurnal.models.Subject;
import com.example.jurnal.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    private SubjectService services;

    @Autowired
    public SubjectController(SubjectService services) {this.services = services;}

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("subject", services.findAll());
        return "subject/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("subject", services.findById(id));
        return "subject/show";
    }

    @GetMapping("/new")
    public String newSubject(Model model) {
        model.addAttribute("subject", new Subject());
        return "subject/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("subject")Subject subject) {
        return null;
    }

}
