package com.saketsatpute.multitenancy.repository;

import com.saketsatpute.multitenancy.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
