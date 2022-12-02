package com.ty.hospital.hospitalmanagement_springboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalmanagement_springboot.dto.Branches;
import com.ty.hospital.hospitalmanagement_springboot.repository.BranchesRepository;

@Repository
public class BranchesDao {

	@Autowired
	BranchesRepository branchesRepository;
	
	public Branches saveBranches(Branches branches) {
		return branchesRepository.save(branches);
		
	}
	public Branches updateBranches(Branches branches) {
		return branchesRepository.save(branches);
	}
	public Branches getBranchesById(int id) {
		Optional<Branches> optional= branchesRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}

		
		return null;
		}
		public String deleteBranchesById(int id) {
			branchesRepository.deleteById(id);;
			 return "Deleted";
		}
	
}
