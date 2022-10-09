package questions;

import models.DatosPrueba;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterface.VerificarProductosInterface;
import utils.AccionesWeb;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerificarProductos implements Question<String> {
    private List<DatosPrueba> datosPruebas;

    public VerificarProductos(List<DatosPrueba> datosPruebas) {
        this.datosPruebas = datosPruebas;
    }

    public static VerificarProductos delCarrito(List<DatosPrueba> datosPruebas) {
        return new VerificarProductos(datosPruebas);
    }

    @Override
    public String answeredBy(Actor actor) {
        String producto1 = Text.of(VerificarProductosInterface.getProductoAgregado1()).viewedBy(actor).asString();
        assertEquals(datosPruebas.get(0).getProducto1(), producto1);

        String producto2 = Text.of(VerificarProductosInterface.getProductoAgregado2()).viewedBy(actor).asString();
        assertEquals(datosPruebas.get(0).getProducto2(), producto2);

        String producto3 = Text.of(VerificarProductosInterface.getProductoAgregado3()).viewedBy(actor).asString();
        assertEquals(datosPruebas.get(0).getProducto3(), producto3);

        AccionesWeb accionesWeb = new AccionesWeb();
        accionesWeb.tomarCapturaPantalla();
        return null;
    }
}
