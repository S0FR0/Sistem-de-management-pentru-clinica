package com.clinic.backend.controller;

import com.clinic.backend.model.Specialization;
import com.clinic.backend.service.ScheduleService;
import com.clinic.backend.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialization")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<Specialization>> findAllSpecializations() {
        List<Specialization> specializations = specializationService.findAll();
        return ResponseEntity.ok(specializations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialization> findSpecializationById(@PathVariable Long id){
        return specializationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Specialization> createSpecialization(@RequestBody Specialization specialization){
        Specialization savedSpecialization = specializationService.save(specialization);
        return ResponseEntity.ok(savedSpecialization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialization> updateSpecialization(@PathVariable Long id, @RequestBody Specialization specialization){
        if(!specializationService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        specialization.setId(id);
        specializationService.save(specialization);
        return ResponseEntity.ok(specialization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Specialization> deleteSpecialization(@PathVariable Long id){
        if(!specializationService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        specializationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
