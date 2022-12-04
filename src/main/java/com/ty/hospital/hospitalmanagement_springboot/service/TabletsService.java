package com.ty.hospital.hospitalmanagement_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalmanagement_springboot.dao.TabletsDao;
import com.ty.hospital.hospitalmanagement_springboot.dto.Tablets;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@Service
public class TabletsService {
	@Autowired
	private TabletsDao dao;

	public ResponseEntity<ResponseStructure<Tablets>> saveTablets(Tablets tablets) {
		ResponseStructure<Tablets> responseStructure = new ResponseStructure<Tablets>();
		ResponseEntity<ResponseStructure<Tablets>> responseEntity = new ResponseEntity<ResponseStructure<Tablets>>(
				responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveTablets(tablets));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Tablets>> updateTablets(Tablets tablets, int id) {
		Tablets tablets2 = dao.getTabletsById(id);
		ResponseStructure<Tablets> responseStructure = new ResponseStructure<Tablets>();
		ResponseEntity<ResponseStructure<Tablets>> responseEntity = new ResponseEntity<ResponseStructure<Tablets>>(
				responseStructure, HttpStatus.OK);
		if (tablets2 != null) {
			tablets.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.updateTablets(tablets));
		} else {
			throw null;
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Tablets>> getTabletsById(int id) {
		Tablets tablets2 = dao.getTabletsById(id);
		ResponseStructure<Tablets> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Tablets>> responseEntity = new ResponseEntity<ResponseStructure<Tablets>>(
				responseStructure, HttpStatus.OK);

		if (tablets2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getTabletsById(id));
		} else {
			throw null;
		}
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteTabletsById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteTabletsById(id));
		return responseEntity;
	}

}
