package com.adsms.adsms.services;

import com.adsms.adsms.model.AdverseEvent;
import com.adsms.adsms.model.Patient;
import com.adsms.adsms.model.Staff;
import com.adsms.adsms.repositories.AdverseEventRepository;
import com.adsms.adsms.repositories.PatientRepository;
import com.adsms.adsms.repositories.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoordinatorService {

    PatientRepository patientRepository;
    StaffRepository staffRepository;

    public CoordinatorService(PatientRepository patientRepository, StaffRepository staffRepository) {
        this.patientRepository = patientRepository;
        this.staffRepository = staffRepository;
    }

    public List<Patient> getAll() {
        List<Patient> adverseEvents = new ArrayList<>();
                this.patientRepository.findAll().forEach(adverseEvents::add);
        return adverseEvents;
    }

    public Staff createStaff(Staff staff){
        return staffRepository.save(staff);
    }
}



