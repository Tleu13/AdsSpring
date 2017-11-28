package com.adsms.adsms.model;


import com.adsms.adsms.utility.LocalDateConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "drug_administration")
public class DrugAdministration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_administration_id")
    private int drugAdministrationId;
    @Column(name = "drug_status")
    private String drugStatus;
    @Column(name = "drug_administration_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate drugAdministrationDate;
    @Column(name = "drug_administration_comment")
    private String drugAdministrationComment;
    @OneToOne
    @JoinColumn(name = "receipt_id")
    Receipt receipt;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    Patient patient;
}
