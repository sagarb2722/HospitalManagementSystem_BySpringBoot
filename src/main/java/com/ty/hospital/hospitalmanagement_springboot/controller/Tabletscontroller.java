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

import com.ty.hospital.hospitalmanagement_springboot.dto.Tablets;
import com.ty.hospital.hospitalmanagement_springboot.service.TabletsService;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("tablets")
public class Tabletscontroller {
	@Autowired
	private TabletsService tabletsService;

	@ApiOperation(value = "Save tablets", notes = "It is Used To Save The tablets")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Tablets>> saveTablets(@RequestBody @Valid Tablets tablets) {
		return tabletsService.saveTablets(tablets);
	}

	@ApiOperation(value = "Update tablets", notes = "It Is Used To Save The tablets")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Tablets>> updateTablets(@RequestBody Tablets tablets,
			@RequestParam int id) {
		return tabletsService.updateTablets(tablets, id);
	}

	@ApiOperation(value = "Get tablets By Id", notes = "It Is Used To Get The tablets By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Tablets>> getTabletsById(@RequestParam int id) {
		return tabletsService.getTabletsById(id);
	}

	@ApiOperation(value = "Delete tablets By Id", notes = "It Is Used To tablets person By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteTabletsById(@PathVariable int id) {
		return tabletsService.deleteTabletsById(id);
	}

}
