package com.adsms.adsms.repositories;

import com.adsms.adsms.model.Event;
import com.adsms.adsms.model.Research;
import com.adsms.adsms.model.TaskPrototype;
import com.adsms.adsms.model.Task;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {
 List<Event> findAllByResearch(Research research);














}
