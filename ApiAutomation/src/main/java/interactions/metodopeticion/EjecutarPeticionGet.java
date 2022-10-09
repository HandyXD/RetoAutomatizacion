package interactions.metodopeticion;

import models.DatosPrueba;
import models.ParametrosPeticion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EjecutarPeticionGet implements Interaction {

    ParametrosPeticion parametrosPeticion;

    public EjecutarPeticionGet(ParametrosPeticion parametrosPeticion) {
        this.parametrosPeticion = parametrosPeticion;
    }

    public static EjecutarPeticionGet enElEndPoint(ParametrosPeticion parametrosPeticion) {
        return instrumented(EjecutarPeticionGet.class, parametrosPeticion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> headers = parametrosPeticion.getHeaders();

        actor.attemptsTo(
                Get.resource(parametrosPeticion.getEndpoint() + "/" + DatosPrueba.getMap().get("id").toString())
                        .with(request -> request.headers(headers)
                                .relaxedHTTPSValidation())
        );
    }
}
