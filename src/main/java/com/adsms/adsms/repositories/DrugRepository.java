package com.adsms.adsms.repositories;


import com.adsms.adsms.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends CrudRepository<Drug,Integer> {
}
