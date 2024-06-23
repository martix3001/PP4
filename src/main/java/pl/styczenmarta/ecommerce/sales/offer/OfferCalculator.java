package pl.styczenmarta.ecommerce.sales.offer;

import pl.styczenmarta.ecommerce.sales.cart.CartLine;
import pl.styczenmarta.ecommerce.sales.offer.Offer;

import java.math.BigDecimal;
import java.util.List;

public class OfferCalculator {
    public Offer calculate(List<CartLine> lines) {
        return new Offer (
                BigDecimal.valueOf(10).multiply(new BigDecimal(lines.size())),
                lines.size()
        );

        //WPROWADZIC PRAWDZIWA IMPLEMENTACJE CENY
    }
}
