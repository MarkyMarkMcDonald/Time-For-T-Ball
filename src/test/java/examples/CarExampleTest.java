package examples;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class CarExampleTest {

    @Test
    public void oneToOneMapping() {
        CarRecord carRecord = new CarRecord("Batmobile", null);
        CarBuilder carBuilder = new CarBuilder();

        CarTransformer carTransformer = new CarTransformer();
        carTransformer
                .withMapping(CarRecord::getName, CarBuilder::withName)
                .withMapping(CarRecord::getCreatedAt, CarBuilder::withCreatedAt, value -> null);

        CarBuilder completedCarBuilder = carTransformer.transform(carRecord, carBuilder);

        Car car = completedCarBuilder.createCar();
        System.out.println(car);

        assert "Batmobile".equals(car.getName());
    }

    @Test
    public void oneToOneMapping_withTransformation() {
        CarRecord carRecord = new CarRecord("Batmobile", "October-3-1991");
        CarBuilder carBuilder = new CarBuilder();

        CarTransformer carTransformer = new CarTransformer();
        carTransformer
                .withMapping(CarRecord::getName, CarBuilder::withName)
                .withMapping(CarRecord::getCreatedAt, CarBuilder::withCreatedAt, this::legacyDateParser);
        CarBuilder completedCarBuilder = carTransformer.transform(carRecord, carBuilder);

        Car car = completedCarBuilder.createCar();
        System.out.println(car);

        assert "Batmobile".equals(car.getName());
        assert LocalDate.of(1991, Month.OCTOBER, 3).equals(car.getCreatedAt());
    }

    private LocalDate legacyDateParser(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("MMMM-d-yyyy"));
    }

}
