package es.uco.pw.demo.model;

public class Rental {
    private int rentalId;
    private String startDate;
    private String endDate;
    private int reservedSeats;
    private double totalPrice;

    // Getters
    public int getRentalId() {
        return rentalId;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public int getReservedSeats() {
        return reservedSeats;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
