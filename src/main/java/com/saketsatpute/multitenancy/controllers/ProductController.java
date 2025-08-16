package com.saketsatpute.multitenancy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.saketsatpute.multitenancy.model.Product;
import com.saketsatpute.multitenancy.model.Response;
import com.saketsatpute.multitenancy.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping(value="/health")
	public Response helloWorld() {
		Response res = new Response();
		res.setCode("200");
		res.setMessage("working ok");
		return res;

	}
	
	@GetMapping(value="{shopId}/v1/products")
	public Response getProducts(@PathVariable String shopId) {
		Response res = new Response();
		res.setCode("200");
		res.setMessage("shopId -: "+shopId);
		return res;

	}
	
	@GetMapping(value="{shopId}/v2/products")
	public List<Product> getProductList(@PathVariable String shopId) {
		return productService.getProducts(shopId);
	}

}
