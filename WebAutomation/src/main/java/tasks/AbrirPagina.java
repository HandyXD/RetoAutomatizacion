package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import userinterface.AutomationPracticeInterface;
import utils.AccionesWeb;

public class AbrirPagina implements Task {
    private AutomationPracticeInterface automationPracticeInterface;

    public static AbrirPagina automationpractice() {
        return Tasks.instrumented(AbrirPagina.class);
    }

    AccionesWeb interaction = new AccionesWeb();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(automationPracticeInterface));
        interaction.tomarCapturaPantalla();
    }
}
