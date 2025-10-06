package es.uco.pw.demo.model;

import java.time.LocalDate;

public class Registration {

    // Enum interno
    public enum RegistrationType{
        INDIVIDUAL,
        FAMILIAR
    }

    // Atributos
    private int registrationId;
    private RegistrationType type;
    private LocalDate creationDate;

    // Getters
    public int getRegistrationId() {
        return registrationId;
    }

    public RegistrationType getType() {
        return type;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    // Setters
    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public void setType(RegistrationType type) {
        this.type = type;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
