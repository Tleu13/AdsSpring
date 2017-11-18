package com.adsms.adsms.repositories;

import com.adsms.adsms.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff,Integer> {

}
