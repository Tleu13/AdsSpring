package com.adsms.adsms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class TaskPrototype {

    @Id
    @Column(name = "task_prototype_id")
    private int taskPrototypeId;
    @Column(name = "task_name")
    private String task_name;
}
