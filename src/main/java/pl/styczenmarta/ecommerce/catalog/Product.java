package pl.styczenmarta.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    public Product(UUID id, String name, String description,BigDecimal price) {
        this.id = id.toString();
        this.name = name;
        this.description = description;

    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void changePrice(BigDecimal price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public Product setDescription(String description) {
        this.description = description;
        return this;
    }
    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }


}
