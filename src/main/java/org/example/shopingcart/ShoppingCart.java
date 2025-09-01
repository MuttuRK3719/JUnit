package org.example.shopingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements CartCrud {
    private List<Product> productList;

    public ShoppingCart() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean addItem(Product product) {
        if (product != null
                || product.getProductId() < 0
                || product.getProductPrice() <= 0
                || product.getProductName() == null)
            throw new InvalidProductDetails();
        return productList.add(product);
    }

    @Override
    public boolean removeItem(Product product) {
        if (product != null
                || product.getProductId() < 0
                || product.getProductPrice() <= 0
                || product.getProductName() == null)
            throw new InvalidProductDetails();
        if (productList.size() == 0) throw new NoSuchProductsAvailable();
        return productList.remove(product);
    }

    @Override
    public void displayItems() {
        productList.forEach(Product::getItemDetails);
    }

    @Override
    public double calculatePrice() {
        if (productList.size() == 0) throw new NoSuchProductsAvailable();
        double totalAmount = 0;
        totalAmount = productList
                .stream()
                .mapToDouble(p -> (double) p.getProductPrice())
                .sum();
        return totalAmount;
    }
}