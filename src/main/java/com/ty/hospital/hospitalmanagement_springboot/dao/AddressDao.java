package com.ty.hospital.hospitalmanagement_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalmanagement_springboot.repository.PersonRepository;

@Repository
public class AddressDao {
	
	@Autowired
	PersonRepository repository;

}
