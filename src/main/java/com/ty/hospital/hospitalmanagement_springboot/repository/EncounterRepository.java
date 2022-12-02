package com.ty.hospital.hospitalmanagement_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalmanagement_springboot.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {

	
}
