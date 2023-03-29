package com.example.jurnal.services.impl;

import com.example.jurnal.models.Subject;
import com.example.jurnal.repos.SubjectRep;
import com.example.jurnal.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRep rep;

    @Autowired
    public SubjectServiceImpl(SubjectRep rep) {
        this.rep = rep;
    }

    @Override
    public Subject save(Subject subject) {
        return rep.save(subject);
    }

    @Override
    public Subject findById(Long id) {
        return rep.findById(id).orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
    }

    @Override
    public Subject delete(Long id) {
        Subject subject = findById(id);
        subject.setStatus(false);
        return rep.save(subject);
    }

    @Override
    public Subject update(Long id, Subject subject) {
        Subject subjectToBeUpdate = findById(id);

        subjectToBeUpdate.setName(subject.getName());

        return save(subjectToBeUpdate);
    }

    @Override
    public List<Subject> findAll() {
        return rep.findAll();
    }
}

