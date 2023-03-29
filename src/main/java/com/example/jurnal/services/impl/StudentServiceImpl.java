package com.example.jurnal.services.impl;

import com.example.jurnal.models.Grade;
import com.example.jurnal.models.Student;
import com.example.jurnal.models.responces.StudentResponse;
import com.example.jurnal.repos.StudentRep;
import com.example.jurnal.services.GradeService;
import com.example.jurnal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRep rep;
    private final GradeService gradeService;

    @Autowired
    public StudentServiceImpl(StudentRep rep, GradeService gradeService) {
        this.rep = rep;
        this.gradeService = gradeService;
    }

    @Override
    public Student save(Student student) {
        return rep.save(student);
    }

    @Override
    public Student findById(Long id) {
        return rep.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public Student delete(Long id) {
        Student student = findById(id);
        student.setStatus(false);
        return save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student studentToBeUpdate = findById(id);

        studentToBeUpdate.setFirstName(student.getFirstName());
        studentToBeUpdate.setMiddleName(student.getMiddleName());
        studentToBeUpdate.setLastName(student.getLastName());
        studentToBeUpdate.setBirthdate(student.getBirthdate());
        studentToBeUpdate.setSchoolClass(student.getSchoolClass());

        return save(studentToBeUpdate);
    }

    @Override
    public List<Student> findAll() {
        return rep.findAll();
    }

    @Override
    public List<Student> showAvailableStudent() {
        return rep.getAvailableStudent();
    }

    @Override
    public List<StudentResponse> studentsGrade() {
        List<Grade> gradeList = gradeService.getStudentsGrade();
        List<StudentResponse> responseList = new ArrayList<>();

        for (Grade grade : gradeList) {
            StudentResponse studentResponse = new StudentResponse();

            studentResponse.setFirstName(grade.getStudent().getFirstName());
            studentResponse.setMiddleName(grade.getStudent().getMiddleName());
            studentResponse.setLastName(grade.getStudent().getLastName());
            studentResponse.setValue(grade.getValue());
            studentResponse.setTeacher(grade.getTeacher());

            responseList.add(studentResponse);
        }

        return responseList;
    }

}
