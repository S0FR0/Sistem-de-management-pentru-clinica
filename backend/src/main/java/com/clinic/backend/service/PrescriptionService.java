package com.clinic.backend.service;

import com.clinic.backend.model.Prescription;
import com.clinic.backend.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    public Optional<Prescription> findById(Long id) {
        return prescriptionRepository.findById(id);
    }

    public Prescription save(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public void delete(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
