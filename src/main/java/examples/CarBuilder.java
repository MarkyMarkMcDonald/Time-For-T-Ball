package examples;

import java.time.LocalDate;

class CarBuilder {
    private String name;
    private LocalDate createdAt;

    public void withLastSale(String lastSale) {
        this.name = lastSale;
    }

    public void withCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Car createCar() {
        return new Car(name, createdAt);
    }
}