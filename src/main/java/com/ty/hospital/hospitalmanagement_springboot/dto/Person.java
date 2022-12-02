package com.ty.hospital.hospitalmanagement_springboot.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private long phone;
@OneToMany(cascade = CascadeType.ALL)
private List<Encounter> encounter;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public List<Encounter> getEncounter() {
	return encounter;
}
public void setEncounter(List<Encounter> encounter) {
	this.encounter = encounter;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", encounter=" + encounter + "]";
}


}
