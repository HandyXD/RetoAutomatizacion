package stepdefinitions.comunes;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static tasks.comunes.Cargar.cargoLosDatosConLaSiguiente;
import static utils.Constantes.BASE_URL_API;

public class PreparacionEscenariosApiStepDefinition {
    @Before
    public void configuracionInicialApi() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) deseo realizar una peticion con los siguientes datos$")
    public void queDeseoRealizarUnaPeticionConLosSiguientesDatos(String actor, List<Map<String, Object>> datosPrueba) {
        theActorCalled(actor).whoCan(CallAnApi.at(BASE_URL_API));
        theActorCalled(actor).wasAbleTo(
                cargoLosDatosConLaSiguiente(datosPrueba)
        );
    }
}
