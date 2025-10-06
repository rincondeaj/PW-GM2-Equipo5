package es.uco.pw.demo.model;

public class Boat {
    // Enum interno
    public enum BoatType {
        // Embarcaciones de recreo
        LANCHA,
        YATE,
        VELERO,
        MOTO_ACUATICA,
        CATAMARAN,

        // Embarcaciones de pesca
        PESQUERO,
        CANOA_PESQUERA,
        BOTE_ARTESANAL,
        ARRASTRERO,

        // Embarcaciones de transporte
        FERRY,
        BUQUE_DE_CARGA,
        PETROLERO,
        PORTACONTENEDORES,
        CRUCERO,

        // Embarcaciones militares
        FRAGATA,
        DESTRUCTOR,
        SUBMARINO,
        PORTAAVIONES,
        CORBETA,

        // Embarcaciones menores o tradicionales
        BOTE_DE_REMOS,
        CANOA,
        KAYAK,
        PANGA,
        CHALUPA;
    }

    // Atributos
    private String registrationNumber;
    private String name;
    private BoatType type;
    private int capacity;
    private String dimensions;
    private int skipperId;

    // Getters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public BoatType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDimensions() {
        return dimensions;
    }

    public int getSkipperId() {
        return skipperId;
    }

    // Setters
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(BoatType type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setSkipperId(int skipperId) {
        this.skipperId = skipperId;
    }
}
