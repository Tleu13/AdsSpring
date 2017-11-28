package com.adsms.adsms.controllers;

import com.adsms.adsms.model.AdverseEvent;
import com.adsms.adsms.model.Patient;

import org.springframework.http.HttpStatus;
import com.adsms.adsms.model.Staff;
import com.adsms.adsms.services.ChemicalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/chemical")
public class ChemicalRestController {
    private ChemicalService chemicalService;

    public ChemicalRestController(ChemicalService chemicalService) {
        this.chemicalService = chemicalService;
    }

    @PostMapping(value = "/patients/{id}/adverseEvent")
    public void createAdverseEvent(@PathVariable String id){
        Patient patient = new Patient();
        patient.setPatientId(id);
        Staff staff = new Staff();

        staff.setStaffId(3);
        //shodit po id patient ubiditsy cto est i vzyt Staff id
        AdverseEvent adverseEvent = new AdverseEvent();
        adverseEvent.setAdverseAlcohol(false);
        adverseEvent.setAdverseComment("no vodka no dotka");
        adverseEvent.setAdverseDate(LocalDate.now());
        adverseEvent.setAdverseDrug(false);
        adverseEvent.setAdverseName("headache");
        adverseEvent.setPatient(patient);
        adverseEvent.setStaff(staff);
        adverseEvent.setAdverseStatus("not solved");
        chemicalService.createAdverseEvent(adverseEvent);
    }

    @PostMapping(value = "/patients/{id}/drugAdministration")
    public void createDrugAdministration(@PathVariable String id){
        Patient patient = new Patient();
        patient.setPatientId(id);
        chemicalService.createDrugAdministration(patient);
    }

    @GetMapping(value = "/staff/{id}/patients")
    public ResponseEntity<List<Patient>> getChemicalPatients(@PathVariable int id){
        List<Patient> patients;
        patients =  chemicalService.getAllPatients(id);
        if(patients==null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

}
