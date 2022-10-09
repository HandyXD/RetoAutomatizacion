package tasks.booking;

import interactions.ConstruirCuerpoComunesBooking;
import interactions.ConstruirHeaderComunesBooking;
import interactions.metodopeticion.EjecutarPeticionPost;
import models.ParametrosPeticion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constantes.CUERPO_PETICION;
import static utils.Constantes.HEADERS_PETICION;

public class AgregarReserva implements Task {
    private String endpoint;

    public AgregarReserva(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ParametrosPeticion parametros = new ParametrosPeticion();
        actor.attemptsTo(
                ConstruirHeaderComunesBooking.deLaPeticion()
        );
        parametros.setHeaders(actor.recall(HEADERS_PETICION));
        actor.attemptsTo(
                ConstruirCuerpoComunesBooking.deLaPeticion()
        );
        parametros.setEndpoint(endpoint);
        parametros.setBody(actor.recall(CUERPO_PETICION));
        actor.attemptsTo(
                EjecutarPeticionPost.enElEndPoint(parametros)
        );
    }

    public static AgregarReserva enCreateBooking(String endpoint) {
        return instrumented(AgregarReserva.class, endpoint);
    }
}
