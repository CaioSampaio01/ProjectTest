package com.projectstore.octasmartphone;

import com.projectstore.octasmartphone.model.OctaProductModel;
import com.projectstore.octasmartphone.repository.OctaProductRepository;
import com.projectstore.octasmartphone.service.OctaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class OctasmartphoneApplicationTests {

	@Mock
	private OctaProductRepository repository;

	@InjectMocks
	private OctaService service;

	@Test
	void testGetAllProductsOctaInStock() {

		OctaProductModel device = new OctaProductModel();
		device.setId(1L);
		device.setProductName("SmartPhone");
		device.setProductDescription("Azul, Tela 6.5, Câmera Traseira Dupla, Selfies de 16MP");
		device.setSmartphonePrice(BigDecimal.ONE);
		device.setQuantityInventory(Integer.MIN_VALUE);

		List<OctaProductModel> products = Arrays.asList(device);
		when(repository.findAll()).thenReturn(products);

		List<OctaProductModel> result = service.getAllProductsOctaInStock();

		assertEquals(products, result);
	}

	@Test
	void testGetSpecificProductOctaById() {

		Long productId = 1L;
		OctaProductModel device = new OctaProductModel();
		device.setProductName("SmartPhone");
		device.setProductDescription("Azul, Tela 6.5, Câmera Traseira Dupla, Selfies de 16MP");
		device.setSmartphonePrice(BigDecimal.ONE);
		device.setQuantityInventory(Integer.MIN_VALUE);

		when(repository.findById(productId)).thenReturn(Optional.of(device));

		Optional<OctaProductModel> result = service.getSpecificProductOctaById(productId);

		assertEquals(Optional.of(device), result);
	}

	@Test
	void testSaveNewOctaProductInStock() {

		OctaProductModel deviceToSave = new OctaProductModel();
		deviceToSave.setProductName("SmartPhone");
		deviceToSave.setProductDescription("Azul, Tela 6.5, Câmera Traseira Dupla, Selfies de 16MP");
		deviceToSave.setSmartphonePrice(BigDecimal.ONE);
		deviceToSave.setQuantityInventory(Integer.MIN_VALUE);

		when(repository.save(deviceToSave)).thenReturn(deviceToSave);

		OctaProductModel result = service.saveNewOctaProductInStock(deviceToSave);

		assertEquals(deviceToSave, result);
	}

	@Test
	void testDeleteSpecificProductInStockById() {

		Long productId = 1L;

		service.deleteSpecificProductInStockById(productId);

		verify(repository).deleteById(productId);
	}
}
