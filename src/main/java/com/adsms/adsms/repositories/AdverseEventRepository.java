package com.adsms.adsms.repositories;

import com.adsms.adsms.model.AdverseEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdverseEventRepository extends CrudRepository<AdverseEvent,Integer>{

}
