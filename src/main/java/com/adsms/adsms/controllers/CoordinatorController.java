package com.adsms.adsms.controllers;

import com.adsms.adsms.model.Patient;
import com.adsms.adsms.model.Staff;
import com.adsms.adsms.services.CoordinatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

}
