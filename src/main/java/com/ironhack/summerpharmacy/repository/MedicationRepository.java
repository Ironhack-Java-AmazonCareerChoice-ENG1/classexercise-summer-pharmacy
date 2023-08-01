package com.ironhack.summerpharmacy.repository;

import com.ironhack.summerpharmacy.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
