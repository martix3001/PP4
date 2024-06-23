package pl.styczenmarta.ecommerce.sales.offer;

import java.math.BigDecimal;

public class Offer {
    private final BigDecimal total;
    private final int itemsCount;

    public Offer(BigDecimal total, int itemsCount)
    {
        this.total = total;
        this.itemsCount = itemsCount;
    }

    public int getItemsCount() {
        return 0;
    }

    public BigDecimal getTotal() {
        return BigDecimal.ZERO;
    }
}