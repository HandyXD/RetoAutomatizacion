package models;

import java.util.Map;

public class DatosPrueba {
    public static Map<String, Object> getMap() {
        return map;
    }

    public static void setMap(Map<String, Object> map) {
        DatosPrueba.map = map;
    }

    private static Map<String, Object> map;

    private DatosPrueba() {
    }

}
