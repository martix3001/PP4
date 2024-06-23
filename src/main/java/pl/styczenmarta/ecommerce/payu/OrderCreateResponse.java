package pl.styczenmarta.ecommerce.payu;

public class OrderCreateResponse {
    Status status;
    String redirectUri,orderId,extOrderId;

    public Status getStatus() {
        return status;
    }

    public OrderCreateResponse setStatus(Status status) {
        this.status = status;
        return this;
    }

    public OrderCreateResponse setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    public OrderCreateResponse setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getExtOrderId() {
        return extOrderId;
    }

    public OrderCreateResponse setExtOrderId(String extOrderId) {
        this.extOrderId = extOrderId;
        return this;
    }

    public Object getRedirectUri() {
        return redirectUri;
    }

    public Object getOrderId() {
        return orderId;
    }
}
