package pl.StyczenMarta.ecommerce;

import pl.StyczenMarta.ecommerce.catalog.HashMapProductStorage;
import pl.StyczenMarta.ecommerce.catalog.Product;
import pl.StyczenMarta.ecommerce.catalog.ProductCatalog;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductCatalogTest {

    @Test
    void itListAvailableProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();
    }



    @Test
    void itAllowsToAddProduct() {
        ProductCatalog catalog = thereIsProductCatalog();

        catalog.addProduct("Lego set 8083", "Nice one", BigDecimal.valueOf(10));
        List<Product> products = catalog.allProducts();

        assertThat(products)
                .hasSize(1);
    }

    @Test
    void itLoadsSingleProductById() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "Nice one",BigDecimal.valueOf(10));

        Product loaded = catalog.getProductBy(id);

        assertThat(id).isEqualTo(loaded.getId());
    }

    @Test
    void itAllowsChangePrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Lego set 8083", "Nice one", BigDecimal.valueOf(10));

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.getProductBy(id);

        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loaded.getPrice());
    }

    private static ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog(new HashMapProductStorage());
    }
}
