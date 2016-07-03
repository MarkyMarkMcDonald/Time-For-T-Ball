package examples.banana;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class BananaExampleTest {

    @Test
    public void oneToOneMapping() {
        BananaRecord bananaRecord = new BananaRecord("Brazil", null);
        BananaBuilder bananaBuilder = new BananaBuilder();

        BananaTransformer bananaTransformer = new BananaTransformer();
        bananaTransformer
                .withMapping(BananaRecord::getCountry, BananaBuilder::withCountry)
                .withMapping(BananaRecord::getExpirationDate, BananaBuilder::withExpirationDate, value -> null);

        BananaBuilder completedBananaBuilder = bananaTransformer.transform(bananaRecord, bananaBuilder);

        Banana banana = completedBananaBuilder.createBanana();
        System.out.println(banana);

        assert "Brazil".equals(banana.getCountry());
    }

    @Test
    public void oneToOneMapping_withTransformation() {
        BananaRecord bananaRecord = new BananaRecord("Brazil", "October-3-1991");
        BananaBuilder bananaBuilder = new BananaBuilder();

        BananaTransformer bananaTransformer = new BananaTransformer();
        bananaTransformer
                .withMapping(BananaRecord::getCountry, BananaBuilder::withCountry)
                .withMapping(BananaRecord::getExpirationDate, BananaBuilder::withExpirationDate, this::legacyDateParser);
        BananaBuilder completedBananaBuilder = bananaTransformer.transform(bananaRecord, bananaBuilder);

        Banana banana = completedBananaBuilder.createBanana();
        System.out.println(banana);

        assert "Brazil".equals(banana.getCountry());
        assert LocalDate.of(1991, Month.OCTOBER, 3).equals(banana.getExpirationDate());
    }

    private LocalDate legacyDateParser(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("MMMM-d-yyyy"));
    }

}
