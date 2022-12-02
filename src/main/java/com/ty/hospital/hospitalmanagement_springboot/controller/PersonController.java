package com.ty.hospital.hospitalmanagement_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital.hospitalmanagement_springboot.dto.Person;
import com.ty.hospital.hospitalmanagement_springboot.service.PersonService;
import com.ty.hospital.hospitalmanagement_springboot.util.ResponseStructure;

@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonService personService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person, @RequestParam int id) {
		return personService.updatePerson(person, id);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return personService.getPersonById(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deletePersonById(@PathVariable int id) {
		return personService.deletePersonById(id);
	}
}