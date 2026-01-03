package com.clinic.backend.controller;

import com.clinic.backend.model.Medicine;
import com.clinic.backend.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicine() {
        List<Medicine> medicines = medicineService.findAll();

        return ResponseEntity.ok(medicines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        return medicineService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
        Medicine savedMedicine = medicineService.save(medicine);

        return ResponseEntity.ok(savedMedicine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
        if(!medicineService.findById(id).isPresent()) {
            return  ResponseEntity.notFound().build();
        }

        medicine.setId(id);
        Medicine updated = medicineService.save(medicine);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medicine> deleteMedicine(@PathVariable Long id) {
        if(!medicineService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        medicineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
