package pl.styczenmarta.ecommerce.sales;

import pl.styczenmarta.ecommerce.sales.cart.Cart;
import pl.styczenmarta.ecommerce.sales.cart.InMemoryCartStorage;
import pl.styczenmarta.ecommerce.sales.offer.Offer;
import pl.styczenmarta.ecommerce.sales.offer.OfferCalculator;


public class SalesFacade {
    private final OfferCalculator calculator;
    private InMemoryCartStorage cartStorage;
    private OfferCalculator offerCalculator;

    public SalesFacade(InMemoryCartStorage cartStorage, OfferCalculator calculator){
        this.cartStorage = cartStorage;
        this.calculator = calculator;
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);

        cart.addProduct(productId);
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = loadCartForCustomer(customerId);
        return offerCalculator.calculate(cart.getLines());
    }

    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.findByCustomerId(customerId)
                .orElse(Cart.empty());
    }
}
