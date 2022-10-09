package stepdefinitions.booking;

import exceptions.BookingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import questions.booking.CodigoRespuestaServicio;
import questions.booking.VerificacionUpdateBooking;
import tasks.booking.ActualizarReserva;
import tasks.preparacion.GenerarToken;

import static exceptions.BookingException.RESPUESTA_SERVICIO_NO_ESPERADA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constantes.COMUN_ENDPOINT_BOOKING;
import static utils.Constantes.CREATE_TOKEN;

public class ServicioUpdateBookingStepDefinition {
    @Cuando("realizo la acutalizacion de una reserva en get booking")
    public void realizoLaAcutalizacionDeUnaReservaEnGetBooking() {
        theActorInTheSpotlight().attemptsTo(
                GenerarToken.paraConsultar(CREATE_TOKEN)
        );
        theActorInTheSpotlight().attemptsTo(
                ActualizarReserva.enUpdateBooking(COMUN_ENDPOINT_BOOKING)
        );
    }

    @Entonces("deberia ver la respuesta exitosa de la actualizacion realizada en update booking")
    public void deberiaVerLaRespuestaExitosaDeLaActualizacionRealizadaEnUpdateBooking() {
        theActorInTheSpotlight().should(
                seeThat(CodigoRespuestaServicio.updateBookingExitoso()).orComplainWith(BookingException.class, RESPUESTA_SERVICIO_NO_ESPERADA),
                seeThat(VerificacionUpdateBooking.contraElResponse()).orComplainWith(BookingException.class, RESPUESTA_SERVICIO_NO_ESPERADA)
        );
    }
}
