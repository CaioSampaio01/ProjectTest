package com.projectstore.octasmartphone.controller;

import com.projectstore.octasmartphone.model.OctaProductModel;
import com.projectstore.octasmartphone.service.OctaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class OctaProductController {

	@Autowired
	private OctaService service;

	@GetMapping
	public ResponseEntity<List<OctaProductModel>> getAllProducts() {
		List<OctaProductModel> allProducts = service.getAllProductsOctaInStock();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OctaProductModel> getProductById(@PathVariable Long id) {
		Optional<OctaProductModel> product = service.getSpecificProductOctaById(id);
		return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<OctaProductModel> createProduct(@RequestBody OctaProductModel device) {
		OctaProductModel savedProduct = service.saveNewOctaProductInStock(device);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		service.deleteSpecificProductInStockById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}