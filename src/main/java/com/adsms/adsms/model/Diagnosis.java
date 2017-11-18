package com.adsms.adsms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosis_id")
    private int diagnosisId;
    @Column(name = "risk_factor")
    private String riskFactor;
    @Column(name = "localization_disease")
    private String localizationDisease;
    @Column(name = "prevalence")
    private String prevalence;
    @Column(name = "clinical_form")
    private String clinicalForm;
    @Column(name = "mbt_status")
    private String mbtStatus;
    @Column(name = "patient_type")
    private String patient_type;
    @Column(name = "dst_status")
    private String dstStatus;
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
