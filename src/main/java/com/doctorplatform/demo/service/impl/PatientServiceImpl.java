package com.doctorplatform.demo.service.impl;
import com.doctorplatform.demo.entity.PatientEntity;
import com.doctorplatform.demo.repository.PatientRepository;
import com.doctorplatform.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientEntity addPatient(PatientEntity patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientEntity getPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
