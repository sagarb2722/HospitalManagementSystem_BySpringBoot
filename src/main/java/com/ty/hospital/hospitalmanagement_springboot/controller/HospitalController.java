package com.ty.hospital.hospitalmanagement_springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("hospital")
public class HospitalController {

	@Autowired
	HospitalService hospitalService;

	@ApiOperation(value = "Save Hospital", notes = "It is Used To Save The Hospital")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody  @Valid Hospital hospital) {
		return hospitalService.saveHospital(hospital);

	}

	@ApiOperation(value = "Update Hospital", notes = "It Is Used To Save The Hospital")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital,
			@RequestParam int id) {
		return hospitalService.updateHospital(hospital, id);

	}

	@ApiOperation(value = "Get Hospital By Id", notes = "It Is Used To Get The Hospital By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return hospitalService.getHospitalById(id);

	}

	@ApiOperation(value = "Delete Hospital By Id", notes = "It Is Used To Delete Hospital By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(@PathVariable int id) {
		return hospitalService.deleteHospitalById(id);

	}

}
