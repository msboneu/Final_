package digitalHouse.integrador8.travels.utils;

import digitalHouse.integrador8.travels.entity.Paquete;
import digitalHouse.integrador8.travels.entity.Servicios;

public class TravelFactory {

    private static TravelFactory travelFactory;
    private TravelFactory() {}

    public static TravelFactory getInstance() {
        if (travelFactory == null) {
            travelFactory = new TravelFactory();
        }
        return travelFactory;
    }

    public Paquete creadorPaquetes(String tipoServicio, Double precio, Servicios servicios) {
        return switch (tipoServicio) {
            case "premium" -> new Paquete("premium", precio, servicios);
            case "basic" -> new Paquete("basic", precio, servicios);
            default -> null;
        };
    }
}
