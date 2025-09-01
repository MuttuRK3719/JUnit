import org.example.shopingcart.CartCrud;
import org.example.shopingcart.NoSuchProductsAvailable;
import org.example.shopingcart.Product;
import org.example.shopingcart.ShoppingCart;
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

}
