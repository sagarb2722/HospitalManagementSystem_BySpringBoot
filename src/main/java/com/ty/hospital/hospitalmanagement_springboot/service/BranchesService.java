package com.ty.hospital.hospitalmanagement_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalmanagement_springboot.dao.BranchesDao;
import com.ty.hospital.hospitalmanagement_springboot.dto.Branches;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@Service
public class BranchesService {
	@Autowired
	BranchesDao branchesDao;

	public ResponseEntity<ResponseStructure<Branches>> saveBranches(Branches branches) {
		ResponseEntity<ResponseStructure<Branches>> responseEntity;

		ResponseStructure<Branches> responseStructure = new ResponseStructure<Branches>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(branchesDao.saveBranches(branches));
		return null;

	}

	public ResponseEntity<ResponseStructure<Branches>> updateBranches(Branches branches, int id) {
		ResponseEntity<ResponseStructure<Branches>> responseEntity;

		ResponseStructure<Branches> responseStructure = new ResponseStructure<Branches>();
		Branches branches2 = branchesDao.getBranchesById(id);
		if (branches2 != null) {
			branches.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(branchesDao.saveBranches(branches));

		} else {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("NOT FOUND");
			responseStructure.setData(null);

		}
		return new ResponseEntity<ResponseStructure<Branches>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Branches>> getBranchesById(int id) {
		ResponseEntity<ResponseStructure<Branches>> responseEntity;

		ResponseStructure<Branches> responseStructure = new ResponseStructure<Branches>();
		Branches branches2 = branchesDao.getBranchesById(id);
		if (branches2 != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(branchesDao.getBranchesById(id));
			return new ResponseEntity<ResponseStructure<Branches>>(responseStructure, HttpStatus.OK);
		} else {

		}
		return new ResponseEntity<ResponseStructure<Branches>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<String>> deleteBranchesById(int id) {
		ResponseEntity<ResponseStructure<String>> responseEntity;
		Branches branches2 = branchesDao.getBranchesById(id);

		if (branches2 != null) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(branchesDao.deleteBranchesById(id));
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);

	}
		else {
			
		}
		return new ResponseEntity<ResponseStructure<String>>(null);

	}

}
