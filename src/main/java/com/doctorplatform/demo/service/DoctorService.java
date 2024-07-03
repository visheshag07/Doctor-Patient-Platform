package com.doctorplatform.demo.service;

import com.doctorplatform.demo.entity.DoctorEntity;
import com.doctorplatform.demo.enums.Speciality;

import java.util.List;

public interface DoctorService {
    DoctorEntity addDoctor(DoctorEntity doctor);

    void removeDoctor(Long id);

    List<DoctorEntity> suggestDoctors(String city, Speciality speciality);
}
