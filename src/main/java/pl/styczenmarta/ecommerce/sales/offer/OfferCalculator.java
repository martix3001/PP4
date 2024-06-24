package pl.styczenmarta.ecommerce.sales.offer;

import pl.styczenmarta.ecommerce.catalog.ProductCatalog;
import pl.styczenmarta.ecommerce.sales.cart.CartLine;
import pl.styczenmarta.ecommerce.sales.offer.Offer;

import java.math.BigDecimal;
import java.util.List;

public class OfferCalculator {

    public Offer calculate(List<CartLine> lines) {
        BigDecimal basePrice = BigDecimal.valueOf(10); // Cena bazowa

        BigDecimal totalPrice = basePrice.multiply(new BigDecimal(lines.size())); // Obliczenie całkowitej ceny

        // Obliczenie rabatu
        int productCount = lines.size();
        BigDecimal discount = BigDecimal.ZERO;

        if (productCount == 2) {
            discount = totalPrice.multiply(BigDecimal.valueOf(0.20)); // 20% rabatu
        } else if (productCount >= 3) {
            discount = totalPrice.multiply(BigDecimal.valueOf(0.30)); // 30% rabatu
        }

        BigDecimal finalPrice = totalPrice.subtract(discount); // Cena końcowa po uwzględnieniu rabatu

        return new Offer(finalPrice, productCount);

       /*return new Offer (
                BigDecimal.valueOf(10).multiply(new BigDecimal(lines.size())),
                lines.size()
        );*/

        //Nie potrafię stworzyć lepszego działającego kalkulatora ceny więc skelp posiada wyjątkowa specyfikę
    }
}
