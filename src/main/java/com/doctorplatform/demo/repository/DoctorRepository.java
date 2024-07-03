package com.doctorplatform.demo.repository;

import com.doctorplatform.demo.entity.DoctorEntity;
import com.doctorplatform.demo.entity.PatientEntity;
import com.doctorplatform.demo.enums.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

    List<DoctorEntity> findByCityAndSpeciality(String city, Speciality speciality);
}
