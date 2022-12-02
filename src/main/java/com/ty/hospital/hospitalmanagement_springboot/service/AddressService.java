package com.ty.hospital.hospitalmanagement_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalmanagement_springboot.dao.AddressDao;
import com.ty.hospital.hospitalmanagement_springboot.dto.Address;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundException;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@Service
public class AddressService {
	
	@Autowired
	AddressDao dao;	
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address, int id)
	{
		ResponseEntity<ResponseStructure<Address>> responseEntity;
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		Address  address2 = dao.getAddressrById(id);
		if(address2!=null) {
			address.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(dao.updateAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}else {
		throw new NoSuchIdFoundException();
		}
	}
	
	
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int id)
	{
		ResponseEntity<ResponseStructure<Address>> responseEntity;
		ResponseStructure<Address> responseStructure= new ResponseStructure<Address>();
		Address  address2 = dao.getAddressrById(id);
		if(address2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Found");
		responseStructure.setData(dao.getAddressrById(id));
		}else {
			throw null;
		}
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
	}



}
 