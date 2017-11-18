package com.adsms.adsms.model;

import com.adsms.adsms.utility.LocalDateConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId;
    @Column(name = "event_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate eventDate;
    @Column(name = "event_progress")
    private double eventProgress;
    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;
    @OneToOne
    @JoinColumn(name = "event_prototype_id")
    private EventPrototype eventPrototype;

}
