package pl.StyczenMarta.ecommerce.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.StyczenMarta.ecommerce.catalog.ProductCatalog;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class SalesHTTPTest {

    @Autowired
    TestRestTemplate http;

    @LocalServerPort
    private int port;

    @Autowired
    ProductCatalog catalog;

    @Test
    void itAllowToAcceptOffer(){
        String productId=thereIsExampleProduct("Example Product",BigDecimal.valueOf(10.10));

        String addProductURL=String.format("http://localhost:%s/%s/%s",port,"api/add-to-cart",productId);
        ResponseEntity<Object> addProductResponse=http.postForEntity(addProductURL,null, Object.class);

        String acceptOffer=String.format("http://localhost:%s/%s",port,"api/accept-offer");
        AcceptOfferRequest acceptOfferRequest=new AcceptOfferRequest();


        acceptOfferRequest.setFirstName("Mikołaj").setLastName("Suchan").setEmail("mikolaj.suchan@example");
        ResponseEntity<ReservationDetail> reservationDetailResponseEntity=http.postForEntity(addProductURL,null, ReservationDetail.class);

        assertEquals(reservationDetailResponseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(reservationDetailResponseEntity.getBody().getReservationId());
        assertNotNull(BigDecimal.valueOf(10.10),reservationDetailResponseEntity.getBody().getPaymentUrl());

    }
    private String thereIsExampleProduct(String name, BigDecimal price) {
        var id = catalog.addProduct(name, name,price);
        catalog.changePrice(id, price);
        return "Products";
    }
}
