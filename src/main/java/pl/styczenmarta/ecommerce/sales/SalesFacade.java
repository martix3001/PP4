package pl.styczenmarta.ecommerce.sales;

import pl.styczenmarta.ecommerce.sales.cart.Cart;
import pl.styczenmarta.ecommerce.sales.cart.InMemoryCartStorage;
import pl.styczenmarta.ecommerce.sales.offer.AcceptOfferRequest;
import pl.styczenmarta.ecommerce.sales.offer.Offer;
import pl.styczenmarta.ecommerce.sales.offer.OfferCalculator;
import pl.styczenmarta.ecommerce.sales.order.ReservationDetail;


public class SalesFacade {

    private InMemoryCartStorage cartStorage;
    private OfferCalculator offerCalculator;

    public SalesFacade(InMemoryCartStorage cartStorage, OfferCalculator calculator){
        this.cartStorage = cartStorage;
        this.offerCalculator = calculator;

    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);
        cart.addProduct(productId);
        cartStorage.save(customerId, cart);
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = loadCartForCustomer(customerId);
        return offerCalculator.calculate(cart.getLines());
    }
    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetail();
    }
    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.findByCustomerId(customerId)
                .orElse(Cart.empty());
    }

}
