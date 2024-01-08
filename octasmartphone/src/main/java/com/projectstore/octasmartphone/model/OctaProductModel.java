package com.projectstore.octasmartphone.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_devices")
public class OctaProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String productName;

	@Column(name = "description")
	private String productDescription;

	@Column(name = "price")
	private BigDecimal smartphonePrice;

	@Column(name = "inventory")
	private int quantityInventory;

	public OctaProductModel() {
	}

	public OctaProductModel(Long id, String productName, String productDescription, BigDecimal smartphonePrice,
			int quantityInventory) {
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.smartphonePrice = smartphonePrice;
		this.quantityInventory = quantityInventory;
	}

	public Long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public BigDecimal getSmartphonePrice() {
		return smartphonePrice;
	}

	public int getQuantityInventory() {
		return quantityInventory;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setSmartphonePrice(BigDecimal smartphonePrice) {
		this.smartphonePrice = smartphonePrice;
	}

	public void setQuantityInventory(int quantityInventory) {
		this.quantityInventory = quantityInventory;
	}
}