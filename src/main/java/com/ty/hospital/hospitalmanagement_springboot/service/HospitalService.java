package com.ty.hospital.hospitalmanagement_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalmanagement_springboot.dao.HospitalDao;
import com.ty.hospital.hospitalmanagement_springboot.dto.Hospital;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseEntity<ResponseStructure<Hospital>> responseEntity;

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);
	

	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital, int id) {
		ResponseEntity<ResponseStructure<Hospital>> responseEntity;

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		Hospital hospital2 = hospitalDao.getHospitalById(id);
		if (hospital2 != null) {
			hospital.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(hospitalDao.saveHospital(hospital));

		} else {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("NOT FOUND");
			responseStructure.setData(null);

		}
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		ResponseEntity<ResponseStructure<Hospital>> responseEntity;

		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		Hospital hospital2 = hospitalDao.getHospitalById(id);
		if (hospital2 != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(hospitalDao.getHospitalById(id));
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {

		}
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(int id) {
		ResponseEntity<ResponseStructure<String>> responseEntity;
		Hospital hospital2 = hospitalDao.getHospitalById(id);

		if (hospital2 != null) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(hospitalDao.deleteHospitalById(id));
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);

	}
else {
			
		}
		return new ResponseEntity<ResponseStructure<String>>(null);

	}
}
