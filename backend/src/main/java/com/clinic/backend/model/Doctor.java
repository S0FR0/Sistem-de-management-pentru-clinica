package com.clinic.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String licenceNumber;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "specializationId", nullable = false, unique = false)
    private Specialization specialization;

    @OneToMany(mappedBy = "doctor")
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "doctor")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "doctor")
    private List<Prescription> prescriptions;

    @OneToMany(mappedBy = "doctor")
    private List<MedicalRecord> medicalRecords;

    public Doctor() {}

    public Doctor(String licenceNumber, User user, Specialization specialization) {
        this.licenceNumber = licenceNumber;
        this.user = user;
        this.specialization = specialization;
    }

    public Doctor(String licenceNumber, User user, Specialization specialization, List<Schedule> schedules, List<Reservation> reservations, List<Prescription> prescriptions, List<MedicalRecord> medicalRecords) {
        this.licenceNumber = licenceNumber;
        this.user = user;
        this.specialization = specialization;
        this.schedules = schedules;
        this.reservations = reservations;
        this.prescriptions = prescriptions;
        this.medicalRecords = medicalRecords;
    }

    public Doctor(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
