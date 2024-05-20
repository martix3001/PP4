package pl.styczenmarta.ecommerce;

import pl.styczenmarta.ecommerce.sales.offer.OfferCalculator;
import pl.styczenmarta.ecommerce.sales.SalesFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.styczenmarta.ecommerce.catalog.ArrayListProductStorage;
import pl.styczenmarta.ecommerce.catalog.ProductCatalog;
import pl.styczenmarta.ecommerce.sales.cart.InMemoryCartStorage;

import java.math.BigDecimal;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());
        productCatalog.addProduct("Product 1", "Good,Price($):", BigDecimal.valueOf(10));
        productCatalog.addProduct("Product 2", "Bad,Price($):",BigDecimal.valueOf(20));
        productCatalog.addProduct("Product 3", "Saad,Price($):",BigDecimal.valueOf(30));

        return productCatalog;
    }
    @Bean
    SalesFacade createMySalesFacade() {
        return new SalesFacade(
                new InMemoryCartStorage(),
                new OfferCalculator());
    }
}
