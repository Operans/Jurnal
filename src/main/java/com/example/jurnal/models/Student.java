package com.example.jurnal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @Column(name = "id_student")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "last_name", length = 50)
    @NotNull(message = "can not be null")
    @Size(min = 2, max = 50, message = "must be between 2 and 50")
    String lastName;

    @Column(name = "first_name")
    @NotNull(message = "can not be null")
    @Size(min = 2, max = 50, message = "must be between 2 and 50")
    String firstName;

    @Column(name = "middle_name")
    @NotNull(message = "can not be null")
    @Size(min = 2, max = 50, message = "must be between 2 and 50")
    String middleName;

    @Column(name = "birthdate")
    @NotNull(message = "can not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birthdate;

    @Column(name = "school_class")
    @NotNull(message = "can not be null")
    String schoolClass;

    @OneToMany(mappedBy = "student")
    List<Grade> grade;

    boolean status;

    @PrePersist
    protected void onCreate(){
        status = true;
    }
}
