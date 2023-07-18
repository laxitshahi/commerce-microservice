package com.learningjava.productservice.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningjava.productservice.productservice.dto.ProductRequest;
import com.learningjava.productservice.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProductRepository productRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		// The ReplicaSetUrl will dynamically add the spring.data.mongodb.uri property after the setup
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	// This will run just ONE instance, then destroy it?
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest =  getProductRequest();

		// We make a req to product controller using mockMvc
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(productRequest)))
				.andExpect(status().isCreated());

		// Ensure an object is created
		Assertions.assertEquals(productRepository.findAll().size(), 1);
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("samsung x923er")
				.description("The crazy new samsung phone")
				.price(BigDecimal.valueOf(2342))
				.build();
	}

	@Test
		// This will run just ONE instance, then destroy it?
	void shouldGetProduct() throws Exception {
		// How to I test the ACTUAL data?

		// Test with no data
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
						.andExpect(status().isOk());

		Assertions.assertEquals(productRepository.findAll().size(), 0);
	}
}
