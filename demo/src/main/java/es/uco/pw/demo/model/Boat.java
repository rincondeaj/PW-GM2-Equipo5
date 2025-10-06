package es.uco.pw.demo.model;

public class Boat {
    private String registrationNumber;
    private String name;
    private int capacity;
    private String dimensions;

    // Getters
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getDimensions() {
        return dimensions;
    }

    // Setters
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    
}
