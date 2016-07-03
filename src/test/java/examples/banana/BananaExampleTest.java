package examples.banana;

import org.junit.Before;
import org.junit.Test;
import transformers.Transformer;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class BananaExampleTest {

    private Transformer<BananaRecord, BananaBuilder> bananaTransformer;

    @Before
    public void setUp() throws Exception {
        bananaTransformer = new BananaTransformer();
    }

    @Test
    public void oneToOneMapping() {
        bananaTransformer
                .withMapping(BananaRecord::getCountry, BananaBuilder::withCountry)
                .withMapping(BananaRecord::getExpirationDate, BananaBuilder::withExpirationDate, value -> null);

        Banana banana = bananaTransformer.transform(
                new BananaRecord("Brazil", null),
                new BananaBuilder()
        ).createBanana();

        System.out.println(banana);

        assert "Brazil".equals(banana.getCountry());
    }

    @Test
    public void oneToOneMapping_withTransformation() {

        bananaTransformer
                .withMapping(BananaRecord::getCountry, BananaBuilder::withCountry)
                .withMapping(BananaRecord::getExpirationDate, BananaBuilder::withExpirationDate, this::legacyDateParser);

        Banana banana = bananaTransformer.transform(
                new BananaRecord("Brazil", "October-3-1991"),
                new BananaBuilder()
        ).createBanana();

        System.out.println(banana);

        assert "Brazil".equals(banana.getCountry());
        assert LocalDate.of(1991, Month.OCTOBER, 3).equals(banana.getExpirationDate());
    }

    private LocalDate legacyDateParser(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("MMMM-d-yyyy"));
    }

}
