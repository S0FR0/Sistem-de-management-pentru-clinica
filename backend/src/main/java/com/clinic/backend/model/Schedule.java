package com.clinic.backend.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Schedule {

    public enum Day{
        LUNI, MARTI, MIERCURI, JOI, VINERI, SAMBATA, DUMINICA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctorId", nullable = false, unique = false)
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  Day day;

    @Column(nullable = false)
    private LocalTime timeStart;

    @Column(nullable = false)
    private LocalTime timeFinish;

    public Schedule() {}

    public Schedule(Day day, LocalTime timeStart, LocalTime timeFinish) {
        this.day = day;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
    }

    public Schedule(Doctor doctor, Day day, LocalTime timeStart, LocalTime timeFinish) {
        this.doctor = doctor;
        this.day = day;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
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

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(LocalTime timeFinish) {
        this.timeFinish = timeFinish;
    }

}
