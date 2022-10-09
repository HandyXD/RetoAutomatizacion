package questions.consulta;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static utils.Constantes.COD_RESPUSTA_OK_HTTP;
import static utils.Constantes.INFORME_SERENITY;
import static utils.VerificarCampos.limpiarReporte;
import static utils.VerificarCampos.validarCampo;

public class ConsultaExitosa implements Question<Boolean> {
    private static final Logger LOGGER = LogManager.getLogger(ConsultaExitosa.class);
    private String nombreServicio;

    public ConsultaExitosa(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        limpiarReporte();
        LOGGER.info("Verificacion Codigo Json respuesta");
        boolean validacion = false;
        validacion = validarCampo("Codigo Respuesta ", String.valueOf(SerenityRest.lastResponse().getStatusCode()), COD_RESPUSTA_OK_HTTP, true);
        Serenity.recordReportData().withTitle("Verificacion Respuesta Servicio " + nombreServicio).andContents(Serenity.sessionVariableCalled(INFORME_SERENITY));
        return validacion;
    }
}
