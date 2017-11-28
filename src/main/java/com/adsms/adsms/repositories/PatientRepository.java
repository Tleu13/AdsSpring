package com.adsms.adsms.repositories;

import com.adsms.adsms.model.Patient;

import com.adsms.adsms.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient,String> {
    List<Patient> findByStaffIdAndConfirmed(Staff staffId, boolean isConfirmed);
}
