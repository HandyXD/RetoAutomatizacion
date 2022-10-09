package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import models.DatosPrueba;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.VerificarProductos;
import tasks.AbrirPagina;
import tasks.AgregarProducto;

import java.util.List;

public class RealizarCompraStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) ingreso a la pagina automationpractice$")
    public void queIngresoALaPaginaAutomationpractice(String actor) throws Exception {
        OnStage.theActorCalled(actor).wasAbleTo(AbrirPagina.automationpractice());
    }

    @Cuando("^ingreso productos al carrito$")
    public void ingresoProductosAlCarrito(List<DatosPrueba> datosPrueba) throws Exception {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarProducto.alCarrito(datosPrueba)
        );
    }

    @Entonces("^verificaria que se agreguen todos correctamente para poder comprarlos$")
    public void verificariaQueSeAgreguenTodosCorrectamenteParaPoderComprarlos(List<DatosPrueba> datosPrueba) throws Exception {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerificarProductos.delCarrito(datosPrueba)));
    }
}
