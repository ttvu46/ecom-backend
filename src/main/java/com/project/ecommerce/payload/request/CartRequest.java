package com.project.ecommerce.payload.request;

import jakarta.validation.constraints.NotBlank;

public class CartRequest {
    @NotBlank
    private Integer quantity;

    @NotBlank
    private Integer productId;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
