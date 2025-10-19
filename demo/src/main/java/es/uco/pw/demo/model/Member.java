package es.uco.pw.demo.model;

import java.time.LocalDate;

public class Member {

    // Enum interno
    public enum RoleType {
        TITULAR,
        PAREJA,
        HIJO 
    }

    // Atributos
    private int memberId;
    private String dni;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private LocalDate registrationDate;
    private boolean skipperTitle;
    private RoleType role;

    // Getters
    public int getMemberId() {
        return memberId;
    }

    public String getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public boolean isSkipperTitle() {
        return skipperTitle;
    }

    public RoleType getRole() {
        return role;
    }

    // Setters
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setSkipperTitle(boolean skipperTitle) {
        this.skipperTitle = skipperTitle;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
