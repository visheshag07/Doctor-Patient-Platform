package com.doctorplatform.demo.controller;
import com.doctorplatform.demo.entity.DoctorEntity;
import com.doctorplatform.demo.enums.Speciality;
import com.doctorplatform.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    private String city;

    private Speciality speciality;

    @PostMapping
    public DoctorEntity addDoctor(@RequestBody DoctorEntity doctor) {
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void removeDoctor(@PathVariable Long id) {
        doctorService.removeDoctor(id);
    }

    @GetMapping("/suggest")
    public List<DoctorEntity> suggestDoctors(@RequestParam String city, @RequestParam Speciality speciality) {
        this.city = city;
        this.speciality = speciality;
        return doctorService.suggestDoctors(city, speciality);
    }
}
