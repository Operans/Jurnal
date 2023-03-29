package com.example.jurnal.services.impl;

import com.example.jurnal.models.Teacher;
import com.example.jurnal.repos.TeacherRep;
import com.example.jurnal.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRep rep;

    @Autowired
    public TeacherServiceImpl(TeacherRep rep) {
        this.rep = rep;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return rep.save(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return rep.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
    }

    @Override
    public Teacher delete(Long id) {
        Teacher teacher = findById(id);
        teacher.setStatus(false);
        return rep.save(teacher);
    }

    @Override
    public Teacher update(Long id, Teacher teacher) {
        Teacher teacherToBeUpdate = findById(id);

        teacherToBeUpdate.setFirstName(teacher.getFirstName());
        teacherToBeUpdate.setMiddleName(teacher.getMiddleName());
        teacherToBeUpdate.setLastName(teacher.getLastName());
        teacherToBeUpdate.setSubject(teacher.getSubject());

        return save(teacherToBeUpdate);
    }

    @Override
    public List<Teacher> findAll() {
        return rep.findAll();
    }

}
