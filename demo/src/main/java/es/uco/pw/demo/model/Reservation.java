package es.uco.pw.demo.model;

public class Reservation {
    private int reservationId;
    private String date;
    private int reservedSeats;
    private double estimatedCost;
    private double totalPrice;

    // Getters
    public int getReservationId() {
        return reservationId;
    }
    public String getDate() {
        return date;
    }
    public int getReservedSeats() {
        return reservedSeats;
    }
    public double getEstimatedCost() {
        return estimatedCost;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    } 
}
