package es.uco.pw.demo.model;

import java.time.LocalDate;

public class Rental {

    // Atributos
    private int rentalId;
    private int memberId;
    private int registrationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int reservedSeats;
    private double totalPrice;

    // Getters
    public int getRentalId() {
        return rentalId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
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

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
