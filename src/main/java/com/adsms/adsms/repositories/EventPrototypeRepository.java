package com.adsms.adsms.repositories;

import com.adsms.adsms.model.EventPrototype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventPrototypeRepository extends CrudRepository<EventPrototype,Integer> {

}
