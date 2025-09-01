package org.example.shopingcart;

public class InvalidProductDetails extends RuntimeException {
    public String getMessage() {
        return "product details is invalid";
    }
}
