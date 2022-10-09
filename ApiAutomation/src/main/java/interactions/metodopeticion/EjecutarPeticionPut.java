package interactions.metodopeticion;

import models.DatosPrueba;
import models.ParametrosPeticion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EjecutarPeticionPut implements Interaction {

    ParametrosPeticion parametrosPeticion;

    public EjecutarPeticionPut(ParametrosPeticion parametrosPeticion) {
        this.parametrosPeticion = parametrosPeticion;
    }

    public static EjecutarPeticionPut enElEndPoint(ParametrosPeticion parametrosPeticion) {
        return instrumented(EjecutarPeticionPut.class, parametrosPeticion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> headers = parametrosPeticion.getHeaders();

        actor.attemptsTo(
                Put.to(parametrosPeticion.getEndpoint() + "/" + DatosPrueba.getMap().get("id").toString())
                        .with(request -> request.headers(headers)
                                .body(parametrosPeticion.getBody())
                                .relaxedHTTPSValidation())
        );
    }
}
