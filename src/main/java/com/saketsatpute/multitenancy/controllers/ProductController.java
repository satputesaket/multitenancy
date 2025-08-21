package com.saketsatpute.multitenancy.controllers;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.saketsatpute.multitenancy.configs.TenantMessageSource;
import com.saketsatpute.multitenancy.model.Product;
import com.saketsatpute.multitenancy.model.Response;
import com.saketsatpute.multitenancy.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	private TenantMessageSource tenantMessages;

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@GetMapping(value = "/health")
	public Response helloWorld() {
		Response res = new Response();
		res.setCode("200");
		res.setMessage("working ok");
		return res;

	}

	@GetMapping(value = "{shopId}/v1/products")
	public Response getProducts(@PathVariable String shopId) {
		Response res = new Response();
		res.setCode("200");
		res.setMessage("shopId -: " + shopId);
		return res;

	}

	@GetMapping(value = "{shopId}/v2/products")
	public List<Product> getProductList() {
		log.info("Hello tenant!");
		return productService.getProducts();
	}

	@GetMapping(value = "{shopId}/v2/welcome")
	public Response getWelcomeMessage() {
		log.info("Hello tenant!");
		Response response = new Response();
		response.setCode("200");
		response.setMessage(tenantMessages.getMessage("welcome", Locale.ENGLISH));

		return response;
	}
	
	
	@GetMapping(value = "api/v3/products")
	public List<Product> getProductListV3() {
		log.info("Hello tenant!");
		return productService.getProducts();
	}

	@GetMapping(value = "api/v3/welcome")
	public Response getWelcomeMessageV3() {
		log.info("Hello tenant!");
		Response response = new Response();
		response.setCode("200");
		response.setMessage(tenantMessages.getMessage("welcome", Locale.ENGLISH));

		return response;
	}

}
