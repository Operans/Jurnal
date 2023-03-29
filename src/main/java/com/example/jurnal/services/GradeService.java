package com.example.jurnal.services;

import com.example.jurnal.models.Grade;
import com.example.jurnal.models.Teacher;

import java.util.List;

public interface GradeService extends BaseService<Grade>{

    List<Grade> getStudentsGrade();
}
