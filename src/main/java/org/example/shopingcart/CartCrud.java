package org.example.shopingcart;

public interface CartCrud {
    boolean addItem(Product product);
    boolean removeItem(Product product);
    void displayItems();
    double calculatePrice();
}
