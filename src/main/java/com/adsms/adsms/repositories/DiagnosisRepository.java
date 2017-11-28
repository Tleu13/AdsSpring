package com.adsms.adsms.repositories;


import com.adsms.adsms.model.Diagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends CrudRepository<Diagnosis,Integer> {

}
