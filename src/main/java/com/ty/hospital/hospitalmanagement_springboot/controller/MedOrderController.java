package com.ty.hospital.hospitalmanagement_springboot.controller;

import javax.validation.Valid;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("medorder")
public class MedOrderController {
	@Autowired
	private MedOrderService medOrderService;

	@ApiOperation(value = "Save MedOrder", notes = "It is Used To Save The MedOrder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<MedOrder>> saveMeddOrder(@RequestBody @Valid MedOrder medOrder) {
		return medOrderService.saveMedOrder(medOrder);
	}

	@ApiOperation(value = "Get medorder By Id", notes = "It Is Used To Get The medorder By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(@RequestParam int id) {
		return medOrderService.getMedOrder(id);

	}

	@ApiOperation(value = "Delete medorder By Id", notes = "It Is Used To Delete medorder By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@RequestParam int id) {
		return medOrderService.deleteMedOrder(id);

	}

	@ApiOperation(value = "Update medorder", notes = "It Is Used To Save The medorder")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,
			@RequestParam int id) {
		return medOrderService.updateMedOrder(medOrder, id);
	}

}
