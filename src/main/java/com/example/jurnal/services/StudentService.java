package com.example.jurnal.services;

import com.example.jurnal.models.Student;
import com.example.jurnal.models.responces.StudentResponse;

import java.util.List;

public interface StudentService extends BaseService<Student> {

    List<Student> showAvailableStudent();

    List<StudentResponse> studentsGrade();

}
