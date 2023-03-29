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
@Table(name = "subjects")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    @NotNull(message = "Powel nahui")
    @Size(min = 3, max = 50, message = "Powel nahui")
    String name;

    boolean status;
}