package com.adsms.adsms.controllers;

import com.adsms.adsms.model.Diagnosis;
import com.adsms.adsms.model.Patient;
import com.adsms.adsms.model.Research;
import com.adsms.adsms.model.Staff;
import com.adsms.adsms.services.CoordinatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/coordinator")
public class CoordinatorRestController {
    private CoordinatorService coordinatorService;

    public CoordinatorRestController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @PostMapping(value = "/staffs")
    public void createStaff() {
        Staff staff1 = new Staff();

        staff1.setActivityStatus(true);
        staff1.setDeleteStatus(false);
        staff1.setName("Bob");
        staff1.setPhoneNumber("123123");
        staff1.setSurname("Bond");
        staff1.setRole("Coordinator");
        staff1.setPassword("asdasdasd");
        staff1.setStaffSupervisor(13);
        coordinatorService.createStaff(staff1);
    }


    //#todo regist patient

    @PostMapping("/patients")
    public void createPatient() {

        Staff staff = new Staff();
        staff.setStaffId(3);

        Patient patient = new Patient();
        patient.setPatientId("kaz-test-09");
        patient.setConfirmed(true);
        patient.setDateOfBirthday(LocalDate.of(1991, 12, 10));
        patient.setPatientEmail("asd");
        patient.setInitial("PPP");
        patient.setPassword("asd");
        patient.setPatientSex("male");
        patient.setPatientPhone("8777");
        patient.setStaffId(staff);

        Diagnosis diagnosis = new Diagnosis();

        diagnosis.setPatient(patient);
        diagnosis.setClinicalForm("test");
        diagnosis.setDstStatus("ok");
        diagnosis.setLocalizationDisease("ok");
        diagnosis.setMbtStatus("test");
        diagnosis.setPatient_type("asd");
        diagnosis.setPrevalence("asdasd");
        diagnosis.setRiskFactor("asd");

        coordinatorService.createPatientAndDiagnosis(patient, diagnosis);

        Research research = new Research();
        LocalDate enrollmentDate = LocalDate.of(2017, 11, 23);
        research.setEnrollmentDate(enrollmentDate);
        research.setActivationDate(LocalDate.now());
        research.setActivationStatus(true);
        research.setResearchProgress(0);
        research.setPatient(patient);
        coordinatorService.createResearch(research);
    }

    @GetMapping(value = "/get/")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = coordinatorService.getAll();
        if (patients == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    }

}
