package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class ParametrosPeticion {
    private String endpoint;
    private String body;
    private Map<String, String> headers;

    public ParametrosPeticion() {
        this.endpoint = "";
        this.body = "";
        this.headers = new HashMap<>();
    }

    public void agregarHeader(String llave, String valor) {
        this.headers.put(llave, valor);
    }
}
