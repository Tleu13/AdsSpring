package com.adsms.adsms.controllers;

import com.adsms.adsms.model.Diagnosis;
import com.adsms.adsms.model.Patient;
import com.adsms.adsms.model.Research;
import com.adsms.adsms.model.Staff;
import com.adsms.adsms.services.CoordinatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/coordinator")
public class CoordinatorController {
    private CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @PostMapping("/create/staff")
    public Staff createStaff(@RequestBody Staff staff){
        return coordinatorService.createStaff(staff);
    }


    @RequestMapping(value = "/listAdverse", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> getStaffList() {

        List<Patient> staffs = coordinatorService.getAll();
        if (staffs == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Patient>>(staffs, HttpStatus.OK);
    }

    //#todo regist patient

    @PostMapping("/create/patient")
    public Patient createPatient(){

        Staff staff = new Staff();
        staff.setStaffId(13);

        Patient patient = new Patient();
        patient.setPatientId("kaz-test-07");
        patient.setConfirmed(true);
        patient.setDateOfBirthday(LocalDate.of(1991,12,10));
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
        LocalDate enrollmentDate = LocalDate.of(2017,11,23);
        research.setEnrollmentDate(enrollmentDate);
        research.setActivationDate(LocalDate.now());
        research.setActivationStatus(true);
        research.setResearchProgress(0);
        research.setPatient(patient);
        coordinatorService.createResearch(research);

        return null;
    }
}
