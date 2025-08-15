package com.saketsatpute.multitenancy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.saketsatpute.multitenancy.model.Response;

@RestController
public class ProductController {

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

}
