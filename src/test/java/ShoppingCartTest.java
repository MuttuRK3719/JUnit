import org.example.shopingcart.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingCartTest {
    CartCrud shoppingCart = new ShoppingCart();
    Product mobile = new Product(101, "Mobile", 2000);
    Product tv = new Product(102, "TV", 15000);
    Product fridge = new Product(103, "Fridge", 25000);
    Product laptop = new Product(104, "Laptop", 50000);

    @Test
    void test1() {
        assertEquals(true, shoppingCart.addItem(mobile));
    }

    @Test
    void test2() {
        shoppingCart.addItem(mobile);
        assertEquals(true, shoppingCart.removeItem(mobile));
    }
    @Test
    void test3(){
        shoppingCart.addItem(mobile);
        assertEquals(2000,shoppingCart.calculatePrice());
    }
    @Test
    void test4(){
        assertThrows(NoSuchProductsAvailable.class,()->shoppingCart.removeItem(mobile));
    }
    @Test
    void test5(){
        Product speaker=new Product(101,"Sony",-100);
        assertThrows(InvalidProductDetails.class,()->shoppingCart.addItem(speaker));
    }
    @Test
    void test6(){
        assertThrows(InvalidProductDetails.class,()->shoppingCart.addItem(null));
    }
}
