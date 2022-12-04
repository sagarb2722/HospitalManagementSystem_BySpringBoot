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

import com.ty.hospital.hospitalmanagement_springboot.dto.Tablets;
import com.ty.hospital.hospitalmanagement_springboot.service.TabletsService;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@RestController
@RequestMapping("tablets")
public class Tabletscontroller {
	@Autowired
	private TabletsService tabletsService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Tablets>> saveTablets(@RequestBody Tablets tablets) {
		return tabletsService.saveTablets(tablets);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Tablets>> updateTablets(@RequestBody Tablets tablets, @RequestParam int id) {
		return tabletsService.updateTablets(tablets, id);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Tablets>> getTabletsById(@RequestParam int id) {
		return tabletsService.getTabletsById(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteTabletsById(@PathVariable int id){
		return tabletsService.deleteTabletsById(id);
	}

}
