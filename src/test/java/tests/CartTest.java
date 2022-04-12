package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Cart;

public class CartTest extends BaseTest{

    Cart cart;

    @BeforeMethod (alwaysRun = true)
    public void localSetUp(){
        cart = new Cart(driver);
    }
    @Test (groups = "basic")
    public void basketCalculationTest(){
        cart.goToProducts()
                .addProductToCart()
                    .goToCart();
        Assert.assertEquals(cart.cartCalculation(), cart.cartTotalAmount());


    }

}
