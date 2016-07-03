package examples.banana;

import java.time.LocalDate;

class Banana {

    private final String country;
    private final LocalDate expirationDate;

    public Banana(String country, LocalDate expirationDate) {
        this.country = country;
        this.expirationDate = expirationDate;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
