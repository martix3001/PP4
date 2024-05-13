package pl.StyczenMarta.ecommerce;

import pl.StyczenMarta.ecommerce.sales.SalesFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.StyczenMarta.ecommerce.catalog.ArrayListProductStorage;
import pl.StyczenMarta.ecommerce.catalog.ProductCatalog;

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
        productCatalog.addProduct("set 1", "Decent,Price($):", BigDecimal.valueOf(10));
        productCatalog.addProduct("set 2", "Nice,Price($):",BigDecimal.valueOf(20));
        productCatalog.addProduct("set 3", "Nice one,Price($):",BigDecimal.valueOf(30));

        return productCatalog;
    }
    @Bean
    SalesFacade createMySalesFacade() {
        return new SalesFacade();
    }
}
