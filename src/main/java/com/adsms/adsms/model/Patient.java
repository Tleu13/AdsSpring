package com.adsms.adsms.model;

import com.adsms.adsms.utility.LocalDateConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @Column(name = "patient_id")
    private String patientId;
    @Convert(converter = LocalDateConverter.class)
    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthday;
    @Column(name = "initial")
    private String initial;
    @Column(name = "patient_sex")
    private String patientSex;
    @Column(name = "patient_phone")
    private String patientPhone;
    @Column(name = "patient_email")
    private String patientEmail;
    @Column(name = "password")
    private String password;
    @Column(name = "confirmed")
    private boolean confirmed;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staffId;

}
