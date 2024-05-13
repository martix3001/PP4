package pl.StyczenMarta.ecommerce.sales;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesTest {
    @Test
    void itAddProductToCart() {
        var customerId=thereIsExampleCustomer("Mikołaj");
        var productId=thereIsProduct("product a",BigDecimal.valueOf(10));
        SalesFacade sales=thereIsSalesFacade();

        Offer currentOffer=sales.getCurrentOffer(customerId);
        assertEquals(BigDecimal.valueOf(10),currentOffer.getTotal());
        assertEquals(0,currentOffer.getItemsCount());


    }

    private Object thereIsProduct(String name, BigDecimal value) {
        return null;
    }

    private SalesFacade thereIsSalesFacade() {
        return new SalesFacade();
    }

    @Test
    void itShowsCurrentOffer() {
        SalesFacade sales = thereIsSalesFacade();
        var customerId = thereIsExampleCustomer("Mikołaj");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0, offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    private String thereIsExampleCustomer(String name) {
        return name;
    }

    @Test
    void itRemoveProductFromCart() {

    }

    @Test
    void itAllowToAcceptOffer() {

    }

    @Test
    void itAllowToPayForReservation(){

    }

}
