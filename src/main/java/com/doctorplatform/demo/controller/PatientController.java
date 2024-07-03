package com.doctorplatform.demo.controller;

import com.doctorplatform.demo.entity.DoctorEntity;
import com.doctorplatform.demo.entity.PatientEntity;
import com.doctorplatform.demo.enums.Speciality;
import com.doctorplatform.demo.enums.Symptom;
import com.doctorplatform.demo.service.DoctorService;
import com.doctorplatform.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public PatientEntity addPatient(@RequestBody PatientEntity patient) {
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/{id}")
    public void removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
    }

    @GetMapping("/{id}")
    public PatientEntity getPatient(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @GetMapping("/suggest/{patientId}")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
        PatientEntity patient = patientService.getPatient(patientId);
        if (patient == null) {
            return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
        }

        String city = patient.getCity();
        Symptom symptom = patient.getSymptom();
        Speciality speciality;

        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                speciality = Speciality.ORTHOPAEDIC;
                break;
            case DYSMENORRHEA:
                speciality = Speciality.GYNECOLOGY;
                break;
            case SKIN_INFECTION:
            case SKIN_BURN:
                speciality = Speciality.DERMATOLOGY;
                break;
            case EAR_PAIN:
                speciality = Speciality.ENT;
                break;
            default:
                return new ResponseEntity<>("Invalid symptom", HttpStatus.BAD_REQUEST);
        }

        // Edge-Case 1: If the city is not Delhi, Noida, or Faridabad
        if (!city.equals("Delhi") && !city.equals("Noida") && !city.equals("Faridabad")) {
            return new ResponseEntity<>("We are still waiting to expand to your location", HttpStatus.OK);
        }

        List<DoctorEntity> doctors = doctorService.suggestDoctors(city, speciality);

        // Edge-Case 2: If there isn’t any doctor for that symptom on that location
        if (doctors.isEmpty()) {
            return new ResponseEntity<>("There isn’t any doctor present at your location for your symptom", HttpStatus.OK);
        }

        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}
