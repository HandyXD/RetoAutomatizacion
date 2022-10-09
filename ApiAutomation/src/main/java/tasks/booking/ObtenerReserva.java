package tasks.booking;

import interactions.ConstruirHeaderComunesBooking;
import interactions.metodopeticion.EjecutarPeticionGet;
import models.ParametrosPeticion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constantes.HEADERS_PETICION;

public class ObtenerReserva implements Task {
    private String endpoint;

    public ObtenerReserva(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ParametrosPeticion parametros = new ParametrosPeticion();
        actor.attemptsTo(
                ConstruirHeaderComunesBooking.deLaPeticion()
        );
        parametros.setHeaders(actor.recall(HEADERS_PETICION));
        parametros.setEndpoint(endpoint);
        actor.attemptsTo(
                EjecutarPeticionGet.enElEndPoint(parametros)
        );
    }

    public static ObtenerReserva enGetBooking(String endpoint) {
        return instrumented(ObtenerReserva.class, endpoint);
    }
}