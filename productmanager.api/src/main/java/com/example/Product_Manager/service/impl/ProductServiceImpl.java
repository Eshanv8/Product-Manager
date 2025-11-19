package com.example.Product_Manager.service.impl;
import com.example.Product_Manager.dto.ProductDTO;
import com.example.Product_Manager.model.Product;
import com.example.Product_Manager.repository.ProductRepository;
import com.example.Product_Manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(ProductDTO productDTO) {
        // Map DTO fields to Entity fields
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProducts(String category) {
        // Uses the repository method to find by category, ignoring case
        return productRepository.findByCategoryIgnoreCase(category);
    }

    @Override
    @Transactional
    public void deleteProductByName(String name) {
        // Find the product by name first
        Optional<Product> productOpt = productRepository.findByProductNameIgnoreCase(name);
        
        // Use the repository delete method
        productOpt.ifPresent(productRepository::delete);
    }
}