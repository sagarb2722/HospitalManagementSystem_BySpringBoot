package com.ty.hospital.hospitalmanagement_springboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalmanagement_springboot.dto.Hospital;
import com.ty.hospital.hospitalmanagement_springboot.repository.HospitalRepository;

@Repository
public class HospitalDao {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
		
	}
	public Hospital updateHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional= hospitalRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}

		
		return null;
		}
		public String deleteFoodorderById(int id) {
			hospitalRepository.deleteById(id);;
			 return "Deleted";
		}
		
	
	

}
