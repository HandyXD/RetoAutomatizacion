package questions.booking;

import net.serenitybdd.screenplay.Question;
import questions.consulta.ConsultaExitosa;

import static utils.Constantes.CLASE_QUESTION;

public class CodigoRespuestaServicio {
    private CodigoRespuestaServicio() {
        throw new IllegalStateException(CLASE_QUESTION);
    }

    public static Question createBookingExitoso() {
        return new ConsultaExitosa("Create Booking");
    }

    public static Question getBookingExitoso() {
        return new ConsultaExitosa("Get Booking");
    }

    public static Question updateBookingExitoso() {
        return new ConsultaExitosa("Update Booking");
    }
}
