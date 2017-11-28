package com.adsms.adsms.repositories;

import com.adsms.adsms.model.EventPrototype;
import com.adsms.adsms.model.Protocol;
import com.adsms.adsms.model.Task;
import com.adsms.adsms.model.TaskPrototype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProtocolRepository extends CrudRepository<Protocol,Integer> {

     List<Protocol> findAllByEventPrototype(int eventPrototypeId);
}
