package com.adsms.adsms.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor

public class Staff {

    @Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "activity_status")
    private boolean activityStatus;
    @Column(name = "role")
    private String role;
    @Column(name = "delete_status")
    private boolean deleteStatus;
    @Column(name = "staff_supervisor")
    private int staffSupervisor;
    @Column(name = "password")
    private String password;
}
