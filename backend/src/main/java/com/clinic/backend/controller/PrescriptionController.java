package com.clinic.backend.controller;

import com.clinic.backend.model.Prescription;
import com.clinic.backend.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public ResponseEntity<List<Prescription>> findAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.findAll();
        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> findPrescriptionById(@PathVariable Long id){
        return prescriptionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription){
        Prescription createdPrescription = prescriptionService.save(prescription);
        return ResponseEntity.ok(createdPrescription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription){
        if(!prescriptionService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        prescription.setId(id);
        Prescription updated = prescriptionService.save(prescription);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable Long id){
        if(!prescriptionService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        prescriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
