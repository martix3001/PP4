package pl.styczenmarta.ecommerce.sales.offer;

import java.math.BigDecimal;

public class Offer {
    BigDecimal total;
    int itemsCount;

    public Offer(BigDecimal total, int itemsCount)
    {
        this.total = total;
        this.itemsCount = itemsCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public BigDecimal getTotal() {
        return total;
    }
}