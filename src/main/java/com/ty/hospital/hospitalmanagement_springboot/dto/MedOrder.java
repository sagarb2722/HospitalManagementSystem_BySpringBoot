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
	private List<Tablets> tablets;

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

	public List<Tablets> gettablets() {
		return tablets;
	}

	public void settablets(List<Tablets> tablets) {
		this.tablets = tablets;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}

	@Override
	public String toString() {
		return "MedOrder [id=" + id + ", description=" + description + ", totalcost=" + totalcost + ", tablets="
				+ tablets + "]";
	}

}
