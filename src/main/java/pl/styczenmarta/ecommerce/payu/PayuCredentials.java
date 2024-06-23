package pl.styczenmarta.ecommerce.payu;

public class PayuCredentials {
    static boolean sandbox;

    public static Object getClientSecret() {
        return null;
    }

    public static Object getClientId() {
        return null;
    }

    public String getBaseUrl() {
        if (sandbox) {
            return "https://secure.snd.payu.com";
        } else {
            return "https://secure.payu.com";
        }
    }
}
