package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constantes.*;

public class ConstruirHeaderComunesBooking implements Interaction {

    public static ConstruirHeaderComunesBooking deLaPeticion() {
        return instrumented(ConstruirHeaderComunesBooking.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE_HEADER, APPLICATION_JSON);
        headers.put(ACCEPT, APPLICATION_JSON);
        actor.remember(HEADERS_PETICION, headers);
    }
}
