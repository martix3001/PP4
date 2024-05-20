package pl.styczenmarta.ecommerce;

import pl.styczenmarta.ecommerce.catalog.Product;
import pl.styczenmarta.ecommerce.catalog.ProductCatalog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class HttpProductCatalogTest {
    @LocalServerPort
    private int localPort;
    @Autowired
    TestRestTemplate http;
    @Autowired
    ProductCatalog productCatalog;
    @Test
    void loadsProducts(){
        var id = productCatalog.addProduct("Example Product", "exp desc", BigDecimal.valueOf(10));
        var url = String.format("http://localhost:%s/%s", localPort, "/api/products");

        ResponseEntity<Product[]> response = http.getForEntity(url, Product[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .extracting("name")
                .contains("Example Product");

    }
    @Test
    void homepageLoads(){
        var url = String.format("http://localhost:%s/%s", localPort, "/");

        ResponseEntity<String> response = http.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat((response.getBody())).contains("My Ecommerce");
    }

}
