package com.adsms.adsms.model;

import com.adsms.adsms.utility.LocalDateConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private int receiptId;
    @Column(name = "drug_doze")
    private double drugDoze;
    @Column(name = "receipt_status")
    private boolean receiptStatus;
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "receipt_date")
    private LocalDate receiptDate;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
}
