package interactions.token;

import com.google.gson.Gson;
import models.booking.body.request.RqData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constantes.*;

public class ConstruirCuerpoCreateToken implements Interaction {

    public static ConstruirCuerpoCreateToken deLaPeticion() {
        return instrumented(ConstruirCuerpoCreateToken.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        RqData rqData = new RqData();
        rqData.setUsername(USERNAME_TOKEN);
        rqData.setPassword(PASSWORD_TOKEN);
        String cuerpoJson = gson.toJson(rqData);
        actor.remember(CUERPO_PETICION, cuerpoJson);
    }
}