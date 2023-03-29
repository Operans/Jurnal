package com.example.jurnal.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grades")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "value")
    @NotNull(message = "can not be null")
    @Min(0)
    @Max(5)
    int value;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotNull(message = "can not be null")
    Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @NotNull(message = "can not be null")
    Teacher teacher;
}
