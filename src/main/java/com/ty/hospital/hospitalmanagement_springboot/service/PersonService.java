package com.ty.hospital.hospitalmanagement_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.hospital.hospitalmanagement_springboot.dao.PersonDao;
import com.ty.hospital.hospitalmanagement_springboot.dto.Person;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundException;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundToDelete;
import com.ty.hospital.hospitalmanagement_springboot.exception.NoSuchIdFoundToUpdate;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity;
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.savePerson(person));
		return responseEntity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person, int id) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity;
		Person person2 = dao.getPersonById(id);
		if (person2 != null) {
			person.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updatePerson(person));
			return responseEntity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else
			throw new NoSuchIdFoundToUpdate();
	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity;
		Person person2 = dao.getPersonById(id);
		if (person2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Fetched");
			responseStructure.setData(dao.getPersonById(id));
			return responseEntity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else
			throw new NoSuchIdFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deletePersonById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;
		Person person2=dao.getPersonById(id);
		if(person2!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deletePersonById(id));
		return responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		} else
			throw new NoSuchIdFoundToDelete();
	}

}
