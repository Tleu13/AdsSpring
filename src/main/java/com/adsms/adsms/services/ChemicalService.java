package com.adsms.adsms.services;

import com.adsms.adsms.model.*;
import com.adsms.adsms.repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ChemicalService {
    private AdverseEventRepository adverseEventRepository;
    private DrugAdministrationRepository drugAdministrationRepository;
    private ReceiptRepository receiptRepository;
    private StaffRepository staffRepository;
    private PatientRepository patientRepository;


    public ChemicalService(AdverseEventRepository adverseEventRepository, DrugAdministrationRepository drugAdministrationRepository, ReceiptRepository receiptRepository, StaffRepository staffRepository, PatientRepository patientRepository) {
        this.adverseEventRepository = adverseEventRepository;
        this.drugAdministrationRepository = drugAdministrationRepository;
        this.receiptRepository = receiptRepository;
        this.staffRepository = staffRepository;
        this.patientRepository = patientRepository;
    }

    public void createAdverseEvent(AdverseEvent adverseEvent){
        adverseEventRepository.save(adverseEvent);
    }

    public void createDrugAdministration(Patient patient){
        DrugAdministration drugAdministration = new DrugAdministration();
        Receipt receipt;
        receipt = receiptRepository.findByPatient_PatientId(patient.getPatientId());
        drugAdministration.setPatient(patient);
        drugAdministration.setReceipt(receipt);
        drugAdministration.setDrugAdministrationDate(LocalDate.now());
        drugAdministration.setDrugAdministrationComment("Useless shit");
        drugAdministration.setDrugStatus("Under Control by Skype");
        drugAdministrationRepository.save(drugAdministration);
    }

    public List<Patient> getAllPatients(int stuffId){
        Staff chemical;
        Staff doctor;
        chemical = staffRepository.findOne(stuffId);
        doctor = staffRepository.findOne(chemical.getStaffSupervisor());
        System.out.println(doctor.getStaffId());
        return patientRepository.findByStaffIdAndConfirmed(doctor,true);
    }
}
