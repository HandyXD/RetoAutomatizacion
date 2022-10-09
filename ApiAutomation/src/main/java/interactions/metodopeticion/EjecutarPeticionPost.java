package interactions.metodopeticion;

import models.ParametrosPeticion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EjecutarPeticionPost implements Interaction {

    ParametrosPeticion parametrosPeticion;

    public EjecutarPeticionPost(ParametrosPeticion parametrosPeticion) {
        this.parametrosPeticion = parametrosPeticion;
    }

    public static EjecutarPeticionPost enElEndPoint(ParametrosPeticion parametrosPeticion) {
        return instrumented(EjecutarPeticionPost.class, parametrosPeticion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> headers = parametrosPeticion.getHeaders();

        actor.attemptsTo(
                Post.to(parametrosPeticion.getEndpoint())
                        .with(request -> request.headers(headers)
                                .body(parametrosPeticion.getBody())
                                .relaxedHTTPSValidation())
        );
    }
}
