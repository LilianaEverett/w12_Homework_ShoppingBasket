import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingBasketTest {

    ShoppingBasket basket;
    Product product1;
    Product product2;
    Product product3;

    @Before
    public void before() {
        basket = new ShoppingBasket();
        product1 = new Product("apple", 1.00);
        product2 = new Product("coffee", 3.50);
        product3 = new Product("coffee machine", 43.50);
    }

    @Test
    public void hasTotal() {
        basket.addProduct(product1);
        basket.addProduct(product2);
        assertEquals(4.50, basket.getTotal(), 0.01);
    }

    @Test
    public void hasProductsInBasket() {
        assertEquals(0, basket.countProductsToBuyNoDiscount());
    }

    @Test
    public void hasProductsInTheBasketWithDiscount() {
        assertEquals(0, basket.countProductsToBuyDiscount());
    }

    @Test
    public void canAddAProductToBasket() {
        basket.addProduct(product1);
        assertEquals(1, basket.countProductsToBuyNoDiscount());
    }

    @Test
    public void canRemoveProductFromBasket() {
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.removeProduct(product1);
        assertEquals(1, basket.countProductsToBuyNoDiscount());
    }

    @Test
    public void canEmptyBasket() {
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.empty();
        assertEquals(0, basket.countProductsToBuyNoDiscount());
    }

    @Test
    public void hasLoyaltyCard() {
        assertFalse(basket.getLoyaltyCard());
    }

    @Test
    public void canChangeLoyaltyCard() {
        basket.changeLoyaltyCardStatus();
        assertTrue(basket.getLoyaltyCard());
    }

    @Test
    public void canCheckOutWithoutLoyaltyCard() {
        product1.changeDiscountStatus();
        basket.addProduct(product1);
        basket.addProduct(product1);
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        assertEquals(44.10, basket.checkOut(), 0.1);
    }

    @Test
    public void canCheckOutWithLoyaltyCard() {
        product1.changeDiscountStatus();
        basket.addProduct(product1);
        basket.addProduct(product1);
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.changeLoyaltyCardStatus();
        assertEquals(43.22, basket.checkOut(), 0.1);
    }
}
