package com.ty.hospital.hospitalmanagement_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalmanagement_springboot.dto.MedOrder;
import com.ty.hospital.hospitalmanagement_springboot.service.MedOrderService;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@RestController
@RequestMapping("medorder")
public class MedOrderController {
	@Autowired
	private MedOrderService medOrderService;

	@PostMapping
	public ResponseEntity<ResponseStructure<MedOrder>> saveMeddOrder(@RequestBody MedOrder medOrder) {
		return medOrderService.saveMedOrder(medOrder);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(@RequestParam int id) {
		return medOrderService.getMedOrder(id);

	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@RequestParam int id) {
		return medOrderService.deleteMedOrder(id);

	}

	@PutMapping
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,
			@RequestParam int id) {
		return medOrderService.updateMedOrder(medOrder, id);
	}

}
