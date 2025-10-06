package es.uco.pw.demo.model;

public class Registration {
    private int registrationId;
    private String type;
    private String creationDate;

    // Getters
    public int getRegistrationId() {
        return registrationId;
    }
    public String getType() {
        return type;
    }
    public String getCreationDate() {
        return creationDate;
    }

    // Setters
    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
