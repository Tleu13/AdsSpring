package com.adsms.adsms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;
    @Column(name = "task_progress")
    private int taskProgress;
    @OneToOne
    @JoinColumn(name = "task_prototype_id")
    private TaskPrototype taskPrototype;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
