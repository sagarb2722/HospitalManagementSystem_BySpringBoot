package com.ty.hospital.hospitalmanagement_springboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalmanagement_springboot.dto.MedOrder;
import com.ty.hospital.hospitalmanagement_springboot.repository.MedOrderRepository;

@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepository medOrderRepository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);
	}

	public MedOrder updateMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);
	}

	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder> optional = medOrderRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deleteMedOrderById(int id) {
		medOrderRepository.deleteById(id);
		return "deleted";
	}

}
