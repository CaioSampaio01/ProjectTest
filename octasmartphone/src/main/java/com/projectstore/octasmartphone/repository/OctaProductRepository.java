package com.projectstore.octasmartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectstore.octasmartphone.model.OctaProductModel;

@Repository
public interface OctaProductRepository extends JpaRepository<OctaProductModel, Long> {

}
