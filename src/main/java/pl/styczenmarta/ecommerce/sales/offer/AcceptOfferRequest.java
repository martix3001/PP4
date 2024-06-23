package pl.styczenmarta.ecommerce.sales.offer;

public class AcceptOfferRequest {
    String firstName;
    String lastName;

    public String getEmail() {
        return email;
    }

    public AcceptOfferRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AcceptOfferRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    String email;

    public String getFirstName() {
        return firstName;
    }

    public AcceptOfferRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
