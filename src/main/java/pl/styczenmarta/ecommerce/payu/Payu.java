package pl.styczenmarta.ecommerce.payu;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class Payu {

    RestTemplate http;
    // TODO constructor not complete
    public Payu(RestTemplate http) {
        this.http = http;
    }

    public OrderCreateResponse handle(OrderCreateRequest orderCreateRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", String.format("Bearer %s", getToken()));

        HttpEntity<OrderCreateRequest> request = new HttpEntity<>(orderCreateRequest, headers);

        ResponseEntity<OrderCreateResponse> orderCreateResponseResponseResponse = http.postForEntity("https://secure.payu.com/api/v2_1/orders",
                orderCreateRequest,
                OrderCreateResponse.class
        );

        return orderCreateResponseResponseResponse.getBody();
    }

    private String getToken() {
        String body = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s",
                PayuCredentials.getClientId(),
                PayuCredentials.getClientSecret()
        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>(body,headers);

        ResponseEntity<AccessTokenResponse> atResponse = http.postForEntity(
                "https://secure.snd.payu.com/pl/standard/user/oauth/authorize",
                request,
                AccessTokenResponse.class
        );
        return atResponse.getBody().getAccessToken();
    }
}
