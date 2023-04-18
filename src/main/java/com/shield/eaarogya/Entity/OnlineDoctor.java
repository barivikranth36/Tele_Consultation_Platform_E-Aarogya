package com.shield.eaarogya.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "online_doctors")
public class OnlineDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long onlineDoctorId;

    @Column(name = "isOnline")
    private boolean isOnline;

    @OneToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    public OnlineDoctor(boolean isOnline, Doctor doctor) {
        this.isOnline = isOnline;
        this.doctor = doctor;
    }
}
