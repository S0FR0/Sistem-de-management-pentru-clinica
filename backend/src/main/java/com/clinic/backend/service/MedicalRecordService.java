package com.clinic.backend.service;

import com.clinic.backend.model.MedicalRecord;
import com.clinic.backend.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecord> findAll() {
        return medicalRecordRepository.findAll();
    }

    public Optional<MedicalRecord> findById(Long id) {
        return medicalRecordRepository.findById(id);
    }

    public MedicalRecord save(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public void delete(Long id) {
        medicalRecordRepository.deleteById(id);
    }
}
