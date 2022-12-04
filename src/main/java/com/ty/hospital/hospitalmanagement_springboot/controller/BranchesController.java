package com.ty.hospital.hospitalmanagement_springboot.controller;

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

import com.ty.hospital.hospitalmanagement_springboot.dto.Branches;
import com.ty.hospital.hospitalmanagement_springboot.service.BranchesService;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("branches")
public class BranchesController {

	@Autowired
	BranchesService branchesService;

	@ApiOperation(value = "Save Branches", notes = "It is Used To Save The Branches")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<ResponseStructure<Branches>> saveBranches(@RequestBody Branches branches) {
		return branchesService.saveBranches(branches);

	}

	@ApiOperation(value = "Update Branches", notes = "It Is Used To Save The Branches")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<ResponseStructure<Branches>> updateBranches(@RequestBody Branches branches,
			@RequestParam int id) {
		return branchesService.updateBranches(branches, id);

	}

	@ApiOperation(value = "Get Branches By Id", notes = "It Is Used To Get The Branches By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Branches>> getBranchesById(@RequestParam int id) {
		return branchesService.getBranchesById(id);

	}

	@ApiOperation(value = "Delete Branches By Id", notes = "It Is Used To Delete Branches By Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<ResponseStructure<String>> deleteBranchesById(@PathVariable int id) {
		return branchesService.deleteBranchesById(id);

	}

}
