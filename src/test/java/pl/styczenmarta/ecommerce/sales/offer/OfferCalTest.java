package pl.styczenmarta.ecommerce.sales.offer;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Collections;
import static org.assertj.core.api.Assertions.assertThat;

public class OfferCalTest {
    @Test
    void zeroOfferForEmptyItems() {
        OfferCalculator calculator = new OfferCalculator();

        Offer offer = calculator.calculate(Collections.emptyList());

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
    }
}
