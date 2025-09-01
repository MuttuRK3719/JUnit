package org.example.shopingcart;

public class InvalidProductDetails extends RuntimeException {
    public String getMessage() {
        return this + ":- product details is invalid";
    }
}
