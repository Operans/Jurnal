package com.example.jurnal.repos;

import com.example.jurnal.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRep extends JpaRepository<Grade,Long> {

    @Query(value = "\n" +
            "SELECT s.first_name, s.middle_name, s.last_name, gr.value, gr.teacher_id FROM students as s\n" +
            "INNER JOIN grades as gr\n" +
            "on gr.student_id = s.id_student", nativeQuery = true)
    List<Grade> getStudentsGrade();
}