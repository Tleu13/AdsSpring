package com.adsms.adsms.model;

import com.adsms.adsms.utility.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name= "adverse_event", schema = "public")
@NoArgsConstructor
public class AdverseEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adverse_event_id")
    private int id;
    @NotNull
    @Column(name = "adverse_event_name")
    private String adverseName;
    @NotNull
    @Column(name = "adverse_event_date")
    @Convert(converter = LocalDateConverter.class)
    private java.time.LocalDate adverseDate;
    @Column(name = "adverse_event_comment")
    private String adverseComment;
    @Column(name = "effect_of_alcohol")
    private Boolean adverseAlcohol;
    @Column(name = "effect_of_drug")
    private Boolean adverseDrug;
    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @NotNull
    private String adverseStatus;

}
