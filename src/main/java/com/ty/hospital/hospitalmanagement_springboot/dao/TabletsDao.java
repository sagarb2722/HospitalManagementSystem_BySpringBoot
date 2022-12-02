package com.ty.hospital.hospitalmanagement_springboot.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalmanagement_springboot.dto.Tablets;
import com.ty.hospital.hospitalmanagement_springboot.repository.TabletsRepository;

@Repository
public class TabletsDao {
	@Autowired
	private TabletsRepository tabletsRepository;
	
	

	public Tablets updateTablets(Tablets tablets) {
		return tabletsRepository.save(tablets);
	}

	public Tablets getTabletsById(int id) {
		Optional<Tablets> optional = tabletsRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Tablets saveTablets(Tablets tablets) {
		return tabletsRepository.save(tablets);
	}

}
