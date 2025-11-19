package com.example.Product_Manager.service;

import com.example.Product_Manager.dto.ProductDTO;
import com.example.Product_Manager.model.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(ProductDTO productDTO);

    List<Product> getAllProducts();

    List<Product> searchProducts(String category);

    void deleteProductByName(String name);
}