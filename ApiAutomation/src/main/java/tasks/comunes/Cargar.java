package tasks.comunes;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constantes.CLASE_TASK;

public class Cargar {
    private Cargar() {
        throw new IllegalStateException(CLASE_TASK);
    }

    public static CargarDatosPrueba cargoLosDatosConLaSiguiente(List<Map<String, Object>> informacion) {
        return instrumented(CargarDatosPrueba.class, informacion);
    }
}
