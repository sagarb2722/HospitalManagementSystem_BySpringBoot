package com.ty.hospital.hospitalmanagement_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalmanagement_springboot.dao.EncounterDao;
import com.ty.hospital.hospitalmanagement_springboot.dao.PersonDao;
import com.ty.hospital.hospitalmanagement_springboot.dto.Encounter;
import com.ty.hospital.hospitalmanagement_springboot.dto.Person;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundException;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundToDelete;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundToUpdate;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;
	

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity;
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveEncounter(encounter));
		return responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);
	}

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
			throw new NoSuchIdFoundToUpdate();
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
			throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteEncounterById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;
		Encounter encounter2 = dao.getEncounterById(id);
		if (encounter2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.deleteEncounterById(id));
			return responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,
					HttpStatus.CREATED);
		} else {
			throw new NoSuchIdFoundToDelete();
		}
	}
}
