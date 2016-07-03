package examples.car;

import java.time.LocalDate;

class CarBuilder {
    private String name;
    private LocalDate createdAt;

    public void withName(String name) {
        this.name = name;
    }

    public void withCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Car createCar() {
        return new Car(name, createdAt);
    }
}