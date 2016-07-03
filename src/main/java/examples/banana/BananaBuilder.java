package examples.banana;

import java.time.LocalDate;

class BananaBuilder {
    private String country;
    private LocalDate expirationDate;

    public BananaBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public BananaBuilder withExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Banana createBanana() {
        return new Banana(country, expirationDate);
    }
}