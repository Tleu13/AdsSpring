package com.adsms.adsms.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class EventPrototype {

    @Id
    @Column(name = "event_prototype_id")
    private int eventPrototypeId;
    @Column(name = "event_prototype_name")
    private String eventPrototypeName;
    @Column(name = "event_interval")
    private int eventInterval;

}
