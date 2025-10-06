package es.uco.pw.demo.model;

import java.time.LocalDate;

public class Skipper {

    // Atributos
    private int skipperId;
    private String dni;
    private String name;
    private String lastname;
    private LocalDate birthDate;
    private String expirationDate;

    // Getters
    public int getSkipperId() {
        return skipperId;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    // Setters
    public void setSkipperId(int skipperId) {
        this.skipperId = skipperId;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
