package com.example.jurnal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teachers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name")
    @NotNull(message = "can not be null")
    @Size(min = 2, max = 50, message = "must be between 2 and 50")
    String firstName;

    @Column(name = "last_name")
    @NotNull(message = "can not be null")
    @Size(min = 2, max = 50, message = "must be between 2 and 50")
    String lastName;

    @Column(name = "middle_name")
    @NotNull(message = "can not be null")
    @Size(min = 2, max = 50, message = "must be between 2 and 50")
    String middleName;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @NotNull(message = "can not be null")
    Subject subject;

    boolean status;

    @PrePersist
    protected void onCreate(){
        status = true;
    }
}