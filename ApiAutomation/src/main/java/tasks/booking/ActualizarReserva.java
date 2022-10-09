package tasks.booking;

import com.google.gson.Gson;
import interactions.ConstruirCuerpoComunesBooking;
import interactions.ConstruirHeaderComunesBooking;
import interactions.metodopeticion.EjecutarPeticionPut;
import models.ParametrosPeticion;
import models.booking.body.response.RsData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constantes.*;

public class ActualizarReserva implements Task {
    private String endpoint;

    public ActualizarReserva(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        RsData rsData = gson.fromJson(SerenityRest.lastResponse().asString(), RsData.class);
        ParametrosPeticion parametros = new ParametrosPeticion();
        actor.attemptsTo(
                ConstruirHeaderComunesBooking.deLaPeticion()
        );
        parametros.setHeaders(actor.recall(HEADERS_PETICION));
        parametros.agregarHeader(HEADERS_COOKIE, HEADERS_TOKEN + rsData.getToken());
        actor.attemptsTo(
                ConstruirCuerpoComunesBooking.deLaPeticion()
        );
        parametros.setEndpoint(endpoint);
        parametros.setBody(actor.recall(CUERPO_PETICION));
        actor.attemptsTo(
                EjecutarPeticionPut.enElEndPoint(parametros)
        );
    }

    public static ActualizarReserva enUpdateBooking(String endpoint) {
        return instrumented(ActualizarReserva.class, endpoint);
    }
}
