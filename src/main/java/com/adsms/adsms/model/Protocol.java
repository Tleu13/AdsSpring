package com.adsms.adsms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Protocol {

    @Id
    @Column(name = "protocol_id")
    private int protocolId;
    @Column(name = "event_prototype_id")
    private int eventPrototypeId;
    @Column(name = "task_prototype_id")
    private int taskPrototypeId;

}
