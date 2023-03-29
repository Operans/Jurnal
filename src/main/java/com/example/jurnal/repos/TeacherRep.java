package com.example.jurnal.repos;

import com.example.jurnal.models.Student;
import com.example.jurnal.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRep extends JpaRepository<Teacher, Long> {

    @Query(value = "select * from teachers where status = true ", nativeQuery = true)
    List<Student> getAvailableTeacher();
}
