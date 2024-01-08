package com.projectstore.octasmartphone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectstore.octasmartphone.model.OctaProductModel;
import com.projectstore.octasmartphone.repository.OctaProductRepository;

@Service
public class OctaService {

	@Autowired
	private OctaProductRepository repository;

	public List<OctaProductModel> getAllProductsOctaInStock() {
		return repository.findAll();
	}

	public Optional<OctaProductModel> getSpecificProductOctaById(Long id) {
		return repository.findById(id);
	}

	public OctaProductModel saveNewOctaProductInStock(OctaProductModel device) {
		return repository.save(device);
	}

	public void deleteSpecificProductInStockById(Long id) {
		repository.deleteById(id);
	}
}