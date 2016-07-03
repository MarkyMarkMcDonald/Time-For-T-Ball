package examples.car;


class CarRecord {
    private final String name;
    private final String createdAt;

    public CarRecord(String name, String createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
