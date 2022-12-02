package com.ty.hospital.hospitalmanagement_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalmanagement_springboot.dao.EncounterDao;
import com.ty.hospital.hospitalmanagement_springboot.dto.Encounter;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int id) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity;
		Encounter encounter2 = dao.getEncounterById(id);
		if (encounter2 != null) {
			encounter.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateEncounter(encounter));
			return responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else
			return null;
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity;
		Encounter encounter2 = dao.getEncounterById(id);
		if (encounter2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Fetched");
			responseStructure.setData(dao.getEncounterById(id));
			return responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else
			return null;
	}
}
