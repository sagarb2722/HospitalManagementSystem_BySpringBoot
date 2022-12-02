package com.ty.hospital.hospitalmanagement_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalmanagement_springboot.dto.Person;
import com.ty.hospital.hospitalmanagement_springboot.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	PersonRepository repository;

	public Person savePerson(Person person) {
		return repository.save(person);
	}

	public Person updatePerson(Person person) {
		return repository.save(person);
	}

	public Person getPersonById(int id) {
		return repository.findById(id).get();
	}

	public String deletePersonById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}
