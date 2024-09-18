package com.java.projects.online_store_backend.model.dao;

import com.java.projects.online_store_backend.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product, Long> {
}
