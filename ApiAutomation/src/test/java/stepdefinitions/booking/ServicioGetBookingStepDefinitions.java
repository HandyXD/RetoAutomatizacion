package stepdefinitions.booking;

import exceptions.BookingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import questions.booking.CodigoRespuestaServicio;
import questions.booking.VerificacionGetBooking;
import tasks.booking.ObtenerReserva;

import static exceptions.BookingException.RESPUESTA_SERVICIO_NO_ESPERADA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constantes.COMUN_ENDPOINT_BOOKING;

public class ServicioGetBookingStepDefinitions {

    @Cuando("realizo la peticion para consultar una reserva en get booking")
    public void realizoLaPeticionParaConsultarUnaReservaEnGetBooking() {
        theActorInTheSpotlight().attemptsTo(
                ObtenerReserva.enGetBooking(COMUN_ENDPOINT_BOOKING)
        );
    }

    @Entonces("deberia ver la respuesta exitosa de la consulta realizada en get booking")
    public void deberiaVerLaRespuestaExitosaDeLaConsultaRealizadaEnGetBooking() {
        theActorInTheSpotlight().should(
                seeThat(CodigoRespuestaServicio.getBookingExitoso()).orComplainWith(BookingException.class, RESPUESTA_SERVICIO_NO_ESPERADA),
                seeThat(VerificacionGetBooking.contraElResponse()).orComplainWith(BookingException.class, RESPUESTA_SERVICIO_NO_ESPERADA)
        );
    }

}
