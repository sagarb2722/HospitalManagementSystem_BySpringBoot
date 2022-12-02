package com.ty.hospital.hospitalmanagement_springboot.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private double totalcost;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Tablets> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tablets> getItems() {
		return items;
	}

	public void setItems(List<Tablets> items) {
		this.items = items;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}

	@Override
	public String toString() {
		return "MedOrder [id=" + id + ", description=" + description + ", totalcost=" + totalcost + ", items=" + items
				+ "]";
	}

	

}
