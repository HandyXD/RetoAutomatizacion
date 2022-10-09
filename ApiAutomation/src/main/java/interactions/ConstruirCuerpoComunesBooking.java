package interactions;

import com.google.gson.Gson;
import models.DatosPrueba;
import models.booking.body.Bookingdates;
import models.booking.body.request.RqData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constantes.CUERPO_PETICION;

public class ConstruirCuerpoComunesBooking implements Interaction {

    public static ConstruirCuerpoComunesBooking deLaPeticion() {
        return instrumented(ConstruirCuerpoComunesBooking.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Gson gson = new Gson();
        RqData rqData = new RqData();
        Bookingdates bookingdates = new Bookingdates();
        rqData.setFirstname(DatosPrueba.getMap().get("firstname").toString());
        rqData.setLastname(DatosPrueba.getMap().get("lastname").toString());
        rqData.setTotalprice(DatosPrueba.getMap().get("totalprice").toString());
        rqData.setDepositpaid(DatosPrueba.getMap().get("depositpaid").toString());
        bookingdates.setCheckin(DatosPrueba.getMap().get("checkin").toString());
        bookingdates.setCheckout(DatosPrueba.getMap().get("checkout").toString());
        rqData.setBookingdates(bookingdates);
        rqData.setAdditionalneeds(DatosPrueba.getMap().get("additionalneeds").toString());
        String cuerpoJson = gson.toJson(rqData);
        actor.remember(CUERPO_PETICION, cuerpoJson);
    }
}
