package com.ty.hospital.hospitalmanagement_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalmanagement_springboot.dto.Hospital;
import com.ty.hospital.hospitalmanagement_springboot.service.HospitalService;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;



@RestController
@RequestMapping("hospital")
public class HospitalController {


	@Autowired
	HospitalService hospitalService;

	@PostMapping
	public ResponseEntity< ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);

	}
	@PutMapping
	public ResponseEntity< ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital,@RequestParam int id) {
		return hospitalService.updateHospital(hospital,id);

	}

	@GetMapping
	public ResponseEntity< ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return hospitalService.getHospitalById(id);

	}

	@DeleteMapping({"/id"})
	public ResponseEntity< ResponseStructure<String>> deleteHospitalById(@PathVariable int id) {
		return hospitalService.deleteHospitalById(id);

	}


}



