package stepdefinitions.booking;

import exceptions.BookingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import questions.booking.CodigoRespuestaServicio;
import questions.booking.VerificacionCreateBooking;
import tasks.booking.AgregarReserva;

import static exceptions.BookingException.RESPUESTA_SERVICIO_NO_ESPERADA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constantes.COMUN_ENDPOINT_BOOKING;

public class ServicioCreateBookingStepDefinitions {

    @Cuando("realizo la peticion de reserva en la plataforma")
    public void realizoLaPeticionDeReservaEnLaPlataforma() {
        theActorInTheSpotlight().attemptsTo(
                AgregarReserva.enCreateBooking(COMUN_ENDPOINT_BOOKING)
        );
    }

    @Entonces("deberia ver la respuesta exitosa de la reserva realizada")
    public void deberiaVerLaRespuestaExitosaDeLaReservaRealizada() {
        theActorInTheSpotlight().should(
                seeThat(CodigoRespuestaServicio.createBookingExitoso()).orComplainWith(BookingException.class, RESPUESTA_SERVICIO_NO_ESPERADA),
                seeThat(VerificacionCreateBooking.contraElResponse()).orComplainWith(BookingException.class, RESPUESTA_SERVICIO_NO_ESPERADA)
        );
    }
}
