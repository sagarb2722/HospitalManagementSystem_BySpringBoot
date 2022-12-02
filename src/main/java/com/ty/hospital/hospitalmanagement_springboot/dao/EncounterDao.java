package com.ty.hospital.hospitalmanagement_springboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalmanagement_springboot.dto.Encounter;
import com.ty.hospital.hospitalmanagement_springboot.repository.EncounterRepository;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepository repository;
	
	public Encounter updateEncounter(Encounter encounter) {
		return repository.save(encounter);
	}
	
	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = repository.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		else
			return optional.get();
	}
}
