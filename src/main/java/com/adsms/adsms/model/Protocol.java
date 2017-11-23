package com.adsms.adsms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "protocol_events_tasks")
public class Protocol {

    @Id
    @Column(name = "protocol_id")
    private int protocolId;
    @Column(name = "event_prototype_id")
    private int eventPrototype;
    @Column(name = "task_prototype_id")
    private int taskPrototype;

}
