package examples.banana;

import org.junit.Test;
import transformers.Transformer;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class BananaTransformerTest {

    @Test
    public void oneToOneMapping() {
        Banana banana = new Transformer<BananaRecord, BananaBuilder>()
                .withMapping(BananaRecord::getCountry, BananaBuilder::withCountry)
                .withMapping(BananaRecord::getExpirationDate, BananaBuilder::withExpirationDate, value -> null)
                .transform(
                        new BananaRecord("Brazil", null),
                        new BananaBuilder()
                ).createBanana();

        System.out.println(banana);

        assert "Brazil".equals(banana.getCountry());
    }

    @Test
    public void oneToOneMapping_withTransformation() {
        Banana banana = new Transformer<BananaRecord, BananaBuilder>()
                .withMapping(BananaRecord::getCountry, BananaBuilder::withCountry)
                .withMapping(BananaRecord::getExpirationDate, BananaBuilder::withExpirationDate, this::legacyDateParser)
                .transform(
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
