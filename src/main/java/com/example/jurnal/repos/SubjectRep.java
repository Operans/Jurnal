package com.example.jurnal.repos;

import com.example.jurnal.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRep extends JpaRepository<Subject, Long> {
}
