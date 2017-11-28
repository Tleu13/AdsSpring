package com.adsms.adsms.model;

import com.adsms.adsms.utility.LocalDateConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "research_id")
    private int researchId;
    @Column(name = "enrollment_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate enrollmentDate;
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "activation_date")
    private LocalDate activationDate;
    @Column(name = "activation_status")
    private boolean activationStatus;
    @Column(name = "research_progress")
    private double researchProgress;
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
