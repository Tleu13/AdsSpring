package com.adsms.adsms.model;

import com.sun.istack.internal.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.transaction.Transactional;

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
