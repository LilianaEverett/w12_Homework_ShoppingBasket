import com.sun.tools.internal.xjc.outline.PackageOutline;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    Product product1;

    @Before
    public void before() {
        product1 = new Product("apple", 1.00);
    }

    @Test
    public void hasName() {
        assertEquals("apple", product1.getName());
    }

    @Test
    public void hasPrice() {
        assertEquals(1.00, product1.getPrice(), 0.01);
    }

    @Test
    public void hasDiscount() {
        assertFalse(product1.getDiscount2For1());
    }

    @Test
    public void canChangeDiscountStatus() {
        product1.changeDiscountStatus();
        assertEquals(true, product1.getDiscount2For1());
    }


}
