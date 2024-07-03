package com.doctorplatform.demo.service;

import com.doctorplatform.demo.entity.PatientEntity;

public interface PatientService {
    PatientEntity addPatient(PatientEntity patient);

    void removePatient(Long id);

    PatientEntity getPatient(Long id);
}
