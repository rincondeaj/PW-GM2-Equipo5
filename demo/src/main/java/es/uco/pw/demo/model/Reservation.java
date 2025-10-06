package es.uco.pw.demo.model;

import java.time.LocalDate;

public class Reservation {

    // Atributos
    private int reservationId;
    private int memberId;
    private int registrationId;
    private LocalDate date;
    private int reservedSeats;
    private String purpose;
    private double totalPrice;

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public String getPurpose() {
        return purpose;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
