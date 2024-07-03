package com.doctorplatform.demo.entity;

import com.doctorplatform.demo.enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data

public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, message = "Name should be at least 3 characters long")
    private String name;

    @NotNull
    @Size(max = 20, message = "City should be at most 20 characters long")
    private String city;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Size(min = 10, message = "Phone number should be at least 10 digits long")
    private String phoneNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    // getters and setters
}