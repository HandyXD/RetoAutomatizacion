package questions.booking;

import com.google.gson.Gson;
import models.DatosPrueba;
import models.booking.body.response.RsData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static utils.Constantes.INFORME_SERENITY;
import static utils.VerificarCampos.limpiarReporte;
import static utils.VerificarCampos.validarCampo;

public class VerificacionGetBooking implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(VerificacionGetBooking.class.getName());

    @Override
    public Boolean answeredBy(Actor actor) {
        Gson gson = new Gson();
        LOGGER.info("Verificacion de la consulta exitosa de la reserva");
        limpiarReporte();
        Boolean resultadoFinal = false;
        RsData rsData = gson.fromJson(SerenityRest.lastResponse().asString(), RsData.class);

        Boolean resultadoDato = true;
        resultadoDato = validarCampo("FIRST_NAME", rsData.getFirstname(), DatosPrueba.getMap().get("firstname").toString(), resultadoDato);
        resultadoDato = validarCampo("LAST_NAME", rsData.getLastname(), DatosPrueba.getMap().get("lastname").toString(), resultadoDato);
        resultadoDato = validarCampo("TOTAL_PRICE", rsData.getTotalprice(), DatosPrueba.getMap().get("totalprice").toString(), resultadoDato);
        resultadoDato = validarCampo("DEPOSIT_PAID", rsData.getDepositpaid(), DatosPrueba.getMap().get("depositpaid").toString(), resultadoDato);
        resultadoDato = validarCampo("CHECK_IN", rsData.getBookingdates().getCheckin(), DatosPrueba.getMap().get("checkin").toString(), resultadoDato);
        resultadoDato = validarCampo("CHECKOUT", rsData.getBookingdates().getCheckout(), DatosPrueba.getMap().get("checkout").toString(), resultadoDato);
        resultadoDato = validarCampo("ADDITIONAL_NEEDS", rsData.getAdditionalneeds(), DatosPrueba.getMap().get("additionalneeds").toString(), resultadoDato);

        if (resultadoDato) {
            resultadoFinal = true;
        }
        Serenity.recordReportData().withTitle("Verificacion de la consulta exitosa de la reserva").andContents(Serenity.sessionVariableCalled(INFORME_SERENITY));

        return resultadoFinal;
    }

    public static Question<Boolean> contraElResponse() {
        return new VerificacionGetBooking();
    }
}