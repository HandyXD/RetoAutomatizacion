package tasks;

import models.DatosPrueba;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hover;
import userinterface.AgregarProductosInterface;
import utils.AccionesWeb;

import java.util.List;

public class AgregarProducto implements Task {
    private List<DatosPrueba> datosPruebas;

    public AgregarProducto(List<DatosPrueba> datosPruebas) {
        this.datosPruebas = datosPruebas;
    }

    public static AgregarProducto alCarrito(List<DatosPrueba> datosPruebas) {
        return Tasks.instrumented(AgregarProducto.class, datosPruebas);
    }

    AccionesWeb accionesWeb = new AccionesWeb();
    AgregarProductosInterface registroPrimerPasoInterface = new AgregarProductosInterface();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Hover.over(registroPrimerPasoInterface.getPosicionarHoverProducto()),
                Click.on(registroPrimerPasoInterface.getBtnAddCart()));
        accionesWeb.esperaElementoVisible(AgregarProductosInterface.getWaitDiv());
        accionesWeb.tomarCapturaPantalla();
        actor.attemptsTo(Click.on(AgregarProductosInterface.getBtnContinueShopping()));

        actor.attemptsTo(
                Hover.over(registroPrimerPasoInterface.getPosicionarHoverProducto2()),
                Click.on(registroPrimerPasoInterface.getBtnAddCart2()));
        accionesWeb.esperaElementoVisible(AgregarProductosInterface.getWaitDiv());
        accionesWeb.tomarCapturaPantalla();
        actor.attemptsTo(Click.on(AgregarProductosInterface.getBtnContinueShopping()));

        actor.attemptsTo(
                Hover.over(registroPrimerPasoInterface.getPosicionarHoverProducto3()),
                Click.on(registroPrimerPasoInterface.getBtnAddCart3()));
        accionesWeb.esperaElementoVisible(AgregarProductosInterface.getWaitDiv());
        accionesWeb.tomarCapturaPantalla();
        actor.attemptsTo(Click.on(AgregarProductosInterface.getBtnContinueShopping()),
                Click.on(AgregarProductosInterface.getBtnCarrito())
        );
        accionesWeb.tomarCapturaPantalla();
    }
}