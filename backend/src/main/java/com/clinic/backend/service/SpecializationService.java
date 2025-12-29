package com.clinic.backend.service;

import com.clinic.backend.model.Specialization;
import com.clinic.backend.repository.SpecializationRepository;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;

    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    public Optional<Specialization> findById(Long id) {
        return  specializationRepository.findById(id);
    }

    public Specialization save(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    public void delete(Long id) {
        specializationRepository.deleteById(id);
    }
}
