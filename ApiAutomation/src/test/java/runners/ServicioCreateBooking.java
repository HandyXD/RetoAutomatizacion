package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/booking/servicio_create_booking.feature",
        tags = "@booking",
        glue = {"stepdefinitions.booking",
                "stepdefinitions.comunes"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ServicioCreateBooking {
}
