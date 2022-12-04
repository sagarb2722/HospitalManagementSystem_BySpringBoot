package com.ty.hospital.hospitalmanagement_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalmanagement_springboot.dto.Address;
import com.ty.hospital.hospitalmanagement_springboot.service.AddressService;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("address")
public class AddressController {

	@Autowired
	AddressService service;

	@ApiOperation(value = "Update Address", notes = "It is Used To udpate The address")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,
			@RequestParam int id) {
		return service.updateAddress(address, id);
	}

	@ApiOperation(value = "Get address By Id", notes = "It Is Used To Get The address By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int id) {
		return service.fetchAddressById(id);
	}

}
