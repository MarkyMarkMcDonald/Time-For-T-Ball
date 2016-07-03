package examples.banana;

class BananaRecord {
    private final String country;
    private final String expirationDate;

    public BananaRecord(String country, String expirationDate) {
        this.country = country;
        this.expirationDate = expirationDate;
    }

    public String getCountry() {
        return country;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
