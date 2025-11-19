package com.example.Product_Manager.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {

    @NotBlank(message = "Product name is required.")
    private String productName;

    @NotBlank(message = "Category is required.")
    private String category;

    @NotNull(message = "Price is required.")
    @Min(value = 1, message = "Price must be a positive value.")
    private Double price;

    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Quantity must be a positive value.")
    private Integer quantity;

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}