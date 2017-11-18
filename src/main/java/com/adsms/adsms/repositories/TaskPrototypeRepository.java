package com.adsms.adsms.repositories;


import com.adsms.adsms.model.TaskPrototype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskPrototypeRepository extends CrudRepository<TaskPrototype,Integer>{

}
