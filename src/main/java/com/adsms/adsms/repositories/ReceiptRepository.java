package com.adsms.adsms.repositories;

import com.adsms.adsms.model.Patient;
import com.adsms.adsms.model.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt,Integer> {
        // status ne zabud add
    Receipt findByPatient(Patient patient);
    Receipt findByPatient_PatientId(String patientId);
}
