package examples.car;

import org.junit.Before;
import org.junit.Test;
import transformers.Transformer;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class CarTransformerTest {

    private Transformer<CarRecord, CarBuilder> carTransformer;

    @Before
    public void setUp() throws Exception {
        carTransformer = new Transformer<>();
    }

    @Test
    public void oneToOneMapping() {
        carTransformer
                .withMapping(CarRecord::getName, CarBuilder::withName)
                .withMapping(CarRecord::getCreatedAt, CarBuilder::withCreatedAt, value -> null);

        Car car = carTransformer.transform(
                new CarRecord("Batmobile", null),
                new CarBuilder()
        ).createCar();

        System.out.println(car);

        assert "Batmobile".equals(car.getName());
    }

    @Test
    public void oneToOneMapping_withTransformation() {
        carTransformer
                .withMapping(CarRecord::getName, CarBuilder::withName)
                .withMapping(CarRecord::getCreatedAt, CarBuilder::withCreatedAt, this::legacyDateParser);

        Car car = carTransformer.transform(
                new CarRecord("Batmobile", "October-3-1991"),
                new CarBuilder()
        ).createCar();

        System.out.println(car);

        assert "Batmobile".equals(car.getName());
        assert LocalDate.of(1991, Month.OCTOBER, 3).equals(car.getCreatedAt());
    }

    private LocalDate legacyDateParser(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("MMMM-d-yyyy"));
    }

}
