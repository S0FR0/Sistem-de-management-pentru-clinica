package com.clinic.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reservationId", nullable = false)
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private  Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctorId", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private String diagnosis;

    @Column(nullable = false)
    private String symptoms;

    @Column(nullable = false)
    private String observations;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public MedicalRecord () {}

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }

    public MedicalRecord(Appointment appointment, Patient patient, Doctor doctor, String diagnosis, String symptoms, String observations) {
        this.appointment = appointment;
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;
        this.observations = observations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getReservation() {
        return appointment;
    }

    public void setReservation(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
