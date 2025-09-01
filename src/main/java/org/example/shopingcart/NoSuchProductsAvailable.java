package org.example.shopingcart;

public class NoSuchProductsAvailable extends RuntimeException {
    public String getMessage() {
        return "This type not available product ";
    }
}
