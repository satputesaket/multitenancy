package com.saketsatpute.multitenancy.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saketsatpute.multitenancy.model.Product;
import com.saketsatpute.multitenancy.repository.ProductRepository;
import com.saketsatpute.multitenancy.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		try {

			List<com.saketsatpute.multitenancy.entity.Product> listProducts = productRepository.findAll();

			List<Product> listProductModel = new ArrayList<Product>();

			for (Iterator<com.saketsatpute.multitenancy.entity.Product> iterator = listProducts.iterator(); iterator
					.hasNext();) {
				com.saketsatpute.multitenancy.entity.Product productEntity = (com.saketsatpute.multitenancy.entity.Product) iterator
						.next();
				Product product = new Product();

				product.setName(productEntity.getName());
				product.setPrice(productEntity.getPrice());
				listProductModel.add(product);

			}

			return listProductModel;
		} finally {
		}
	}

}
