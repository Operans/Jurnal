package com.example.jurnal.models.responces;


import com.example.jurnal.models.Teacher;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {

    String lastName;

    String firstName;

    String middleName;

    int value;

    Teacher teacher;

}
