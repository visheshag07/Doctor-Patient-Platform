package com.doctorplatform.demo.entity;

import com.doctorplatform.demo.enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Size(max = 20)
    private String city;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 10)
    private String phoneNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Symptom symptom;

    // getters and setters
}