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

import com.ty.hospital.hospitalmanagement_springboot.dto.Branches;
import com.ty.hospital.hospitalmanagement_springboot.service.BranchesService;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@RestController
@RequestMapping("branches")
public class BranchesController {

	@Autowired
	BranchesService branchesService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Branches>> saveBranches(@RequestBody Branches branches) {
		return branchesService.saveBranches(branches);

	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Branches>> updateBranches(@RequestBody Branches branches,
			@RequestParam int id) {
		return branchesService.updateBranches(branches, id);

	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Branches>> getBranchesById(@RequestParam int id) {
		return branchesService.getBranchesById(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBranchesById(@PathVariable int id) {
		return branchesService.deleteBranchesById(id);

	}

}
