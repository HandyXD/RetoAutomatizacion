package exceptions;

public class BookingException extends AssertionError {
    public static final String RESPUESTA_SERVICIO_NO_ESPERADA = "La respuesta del servicio no fue la esperada";

    public BookingException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
