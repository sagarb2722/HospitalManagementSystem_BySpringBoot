package com.ty.hospital.hospitalmanagement_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalmanagement_springboot.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
