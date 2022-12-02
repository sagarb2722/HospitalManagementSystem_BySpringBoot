package com.ty.hospital.hospitalmanagement_springboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.hospital.hospitalmanagement_springboot.dto.Address;
import com.ty.hospital.hospitalmanagement_springboot.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	AddressRepository repository;
	
	public Address updateAddress(Address address)
	{
		return repository.save(address);
	}
	
	public Address getAddressrById(int id)
	{
		Optional<Address> optional= repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
}
