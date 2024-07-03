package com.doctorplatform.demo.service.impl;




import com.doctorplatform.demo.entity.DoctorEntity;
import com.doctorplatform.demo.enums.Speciality;
import com.doctorplatform.demo.repository.DoctorRepository;
import com.doctorplatform.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorEntity addDoctor(DoctorEntity doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<DoctorEntity> suggestDoctors(String city, Speciality speciality) {
        return doctorRepository.findByCityAndSpeciality(city, speciality);
    }
}

