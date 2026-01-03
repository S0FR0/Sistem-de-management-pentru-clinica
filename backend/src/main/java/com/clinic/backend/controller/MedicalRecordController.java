package com.clinic.backend.controller;

import com.clinic.backend.model.MedicalRecord;
import com.clinic.backend.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medical-record")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordService.findAll();
        return ResponseEntity.ok(medicalRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable Long id) {
        return medicalRecordService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MedicalRecord> createMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecord savedMedicalRecord = medicalRecordService.save(medicalRecord);
        return ResponseEntity.ok(savedMedicalRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long id, @RequestBody MedicalRecord medicalRecord) {
        if(!medicalRecordService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        medicalRecord.setId(id);
        MedicalRecord updated = medicalRecordService.save(medicalRecord);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicalRecord> deleteMedicalRecord(@PathVariable Long id) {
        if(!medicalRecordService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        medicalRecordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
