package examples.car;


import java.time.LocalDate;

class Car {

    private final String name;
    private final LocalDate createdAt;

    public Car(String name, LocalDate createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
