package pl.styczenmarta.ecommerce.payu;


import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import pl.styczenmarta.ecommerce.catalog.Product;
import pl.styczenmarta.ecommerce.payu.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
public class PayuTest {

    /*
    @Test
    void creatingNewPayment() {
        Payu payu = thereIsPayU();

        OrderCreateRequest orderCreateRequest = createExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(orderCreateRequest);

        assertNotNull(response.getRedirectUri()); // Where to redirect customer
        assertNotNull(response.getOrderId()); // transaction id
    }

    private OrderCreateRequest createExampleOrderCreateRequest() {
        OrderCreateRequest createRequest = new OrderCreateRequest();
        createRequest
                .setNotifyUrl("https://my.example.shop.styczenmarta.pl/api/order")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("My ebook")
                .setCurrencyCode("PLN")
                .setTotalAmount(21000)
                .setExtOrderId(UUID.randomUUID().toString())
                .setBuyer((new Buyer())
                        .setEmail("john.doe.example.com")
                        .setFirstName("John").setLastName("Doe")
                        .setLanguage("pl")
                )
                .setProducts(Arrays.asList(new Product()
                        .setId("")
                        .setName("")
                        .setDescription("")
                ));
        return  createRequest;
    }

    private Payu thereIsPayU() {
        return new Payu(new RestTemplate(), PayuCredentials.sandbox("123", "456"));

     */
    }
