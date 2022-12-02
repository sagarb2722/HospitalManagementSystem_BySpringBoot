package com.ty.hospital.hospitalmanagement_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("address")
public class AddressController {
	
	@Autowired
	AddressService service;
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address, @RequestParam int id)
	{
		return service.updateAddress(address, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int id)
	{
		 return service.fetchAddressById(id);
	}

}
