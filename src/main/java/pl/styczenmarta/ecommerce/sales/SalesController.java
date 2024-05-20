package pl.styczenmarta.ecommerce.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.styczenmarta.ecommerce.sales.cart.InMemoryCartStorage;
import pl.styczenmarta.ecommerce.sales.offer.Offer;
import pl.styczenmarta.ecommerce.sales.offer.OfferCalculator;

@RestController
public class SalesController {
    SalesFacade salesFacade = new SalesFacade(
            new InMemoryCartStorage(),
            new OfferCalculator());

    public SalesController(SalesFacade salesFacade) {
        this.salesFacade = salesFacade;
    }

    @GetMapping("/api/current-offer")
    Offer getCurrentOffer() {
        String customerId = getCurrentCustomerId();
        return salesFacade.getCurrentOffer(customerId);

    }

    @PostMapping("/api/accept-offer")
    ReservationDetail acceptOffer(AcceptOfferRequest acceptOfferRequest) {
        String customerId = getCurrentCustomerId();
        ReservationDetail reservationDetails=acceptOfffer(customerId,acceptOfferRequest);
        return reservationDetails;
    }

    private ReservationDetail acceptOfffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetail();
    }

    private String getCurrentCustomerId() {
        return "Marta";
    }

    @PostMapping("/api/add-to-cart/{productId}")
    void addToCart(@PathVariable String productId){
        String customerId = getCurrentCustomerId();
        salesFacade.addToCart(customerId,productId);
    }
}
