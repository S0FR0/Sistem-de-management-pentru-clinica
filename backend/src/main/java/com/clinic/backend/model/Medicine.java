package com.clinic.backend.model;

import jakarta.persistence.*;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String medicine;

    @Column(nullable = false)
    private String dosage;

    @Column(nullable = false)
    private Number duration;

    @ManyToOne
    @JoinColumn(name = "prescriptionId", nullable = false)
    private Prescription prescription;

    public Medicine () {}

    public Medicine(String medicine, String dosage, Number duration, Prescription prescription) {
        this.medicine = medicine;
        this.dosage = dosage;
        this.duration = duration;
        this.prescription = prescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Number getDuration() {
        return duration;
    }

    public void setDuration(Number duration) {
        this.duration = duration;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
