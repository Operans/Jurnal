package com.example.jurnal.services.impl;

import com.example.jurnal.models.Grade;
import com.example.jurnal.repos.GradeRep;
import com.example.jurnal.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradeRep rep;

    @Autowired
    public GradeServiceImpl(GradeRep rep) {
        this.rep = rep;
    }

    @Override
    public Grade save(Grade grade) {
        return rep.save(grade);
    }

    @Override
    public Grade findById(Long id) {
        return rep.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Grade delete(Long id) {
        return null;
    }

    @Override
    public Grade update(Long id, Grade grade) {
        Grade gradeToBeUpdate = findById(id);

        gradeToBeUpdate.setStudent(grade.getStudent());
        gradeToBeUpdate.setTeacher(grade.getTeacher());
        gradeToBeUpdate.setValue(grade.getValue());

        return save(grade);
    }

    @Override
    public List<Grade> findAll() {
        return rep.findAll();
    }

    @Override
    public List<Grade> getStudentsGrade() {
        return rep.getStudentsGrade();
    }
}
