package es.uco.pw.demo.model;

public class Memer {
    private int memberId;
    private String dni;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String registrationDate;
    private String role;

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
    public String getBirthDate() {
        return birthDate;
    }
    public String getAddress() {
        return address;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public String getRole() {
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
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
