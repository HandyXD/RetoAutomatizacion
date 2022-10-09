package tasks.preparacion;

import com.google.gson.Gson;
import interactions.ConstruirHeaderComunesBooking;
import interactions.metodopeticion.EjecutarPeticionPost;
import interactions.token.ConstruirCuerpoCreateToken;
import models.ParametrosPeticion;
import models.booking.body.response.RsData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constantes.*;
import static utils.VerificarCampos.validarCampo;

public class GenerarToken implements Task {
    private String endpoint;
    private static final Logger LOGGER = LogManager.getLogger(GenerarToken.class);
    Gson gson = new Gson();

    public GenerarToken(String endpoint) {
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
                ConstruirCuerpoCreateToken.deLaPeticion()
        );
        parametros.setEndpoint(endpoint);
        parametros.setBody(actor.recall(CUERPO_PETICION));
        actor.attemptsTo(
                EjecutarPeticionPost.enElEndPoint(parametros)
        );

        LOGGER.info("Ejecutar generacion de Token Create Token");
        validarCampo("Codigo Respuesta ", String.valueOf(SerenityRest.lastResponse().getStatusCode()), COD_RESPUSTA_OK_HTTP, true);
        RsData rsData = gson.fromJson(SerenityRest.lastResponse().asString(), RsData.class);
        LOGGER.info("COOKIE : " + rsData.getToken());
    }

    public static GenerarToken paraConsultar(String endpoint) {
        return instrumented(GenerarToken.class, endpoint);
    }
}