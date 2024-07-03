package com.doctorplatform.demo.repository;


import com.doctorplatform.demo.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
