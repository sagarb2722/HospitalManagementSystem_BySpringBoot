package com.ty.hospital.hospitalmanagement_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalmanagement_springboot.dao.MedOrderDao;
import com.ty.hospital.hospitalmanagement_springboot.dto.Tablets;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundException;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundToDelete;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundToUpdate;
import com.ty.hospital.hospitalmanagement_springboot.dto.MedOrder;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	private MedOrderDao medOrderDao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder) {
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.CREATED);
		List<Tablets> tablets = medOrder.gettablets();
		double totalcost = 0;
		for (Tablets tablets2 : tablets) {
			totalcost = totalcost + (tablets2.getPrice() * tablets2.getQuantity());
		}
		totalcost = (totalcost * 0.18) + totalcost;
		medOrder.setTotalcost(totalcost);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(medOrderDao.saveMedOrder(medOrder));
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int id) {
		MedOrder medOrder2 = medOrderDao.getMedOrderById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.CREATED);

		if (medOrder2 != null) {
			medOrder.setId(id);
			List<Tablets> items = medOrder.gettablets();
			double totalCost = 0;
			for (Tablets items2 : items) {
				totalCost = totalCost + (items2.getPrice() * items2.getQuantity());
			}
			totalCost = (totalCost * 0.18) + totalCost;
			medOrder.setTotalcost(totalCost);

			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(medOrderDao.saveMedOrder(medOrder));
		} else {

			throw new NoSuchIdFoundToUpdate();
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrder(int id) {
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.OK);

		MedOrder medOrder = medOrderDao.getMedOrderById(id);

		if (medOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("fetch");
			responseStructure.setData(medOrderDao.getMedOrderById(id));
		} else {
			throw new NoSuchIdFoundException();
		}
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);

		MedOrder medOrder = medOrderDao.getMedOrderById(id);
		if (medOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(medOrderDao.deleteMedOrderById(id));
		} else {
			throw new NoSuchIdFoundToDelete();
		}
		return responseEntity;

	}

}
