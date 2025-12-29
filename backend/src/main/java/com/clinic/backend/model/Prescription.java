package com.clinic.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "doctorId", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "medicalRecordId", nullable = false)
    private MedicalRecord medicalRecord;

    @OneToMany(mappedBy = "prescription")
    private List<Medicine> medicines = new ArrayList<>();

    public Prescription() {}

    @PrePersist
    protected void onCreate() {this.createdAt = LocalDateTime.now();}

    public Prescription(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Prescription(LocalDateTime createdAt, Doctor doctor, MedicalRecord medicalRecord, List<Medicine> medicines) {
        this.createdAt = createdAt;
        this.doctor = doctor;
        this.medicalRecord = medicalRecord;
        this.medicines = medicines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
