package com.example.jurnal.repos;

import com.example.jurnal.models.Grade;
import com.example.jurnal.models.Student;
import com.example.jurnal.models.responces.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRep extends JpaRepository<Student, Long> {

    @Query(value = "select * from students where status = true ", nativeQuery = true)
    List<Student> getAvailableStudent();



}


