package es.uco.pw.demo.model;

import java.time.LocalDate;

public class Reservation {

    // Atributos
    private Integer reservationId;
    private Integer memberId;
    private Integer registrationId;
    private LocalDate date;
    private Integer reservedSeats;
    private String purpose;
    private Double totalPrice;

    // Getters
    public Integer getReservationId() {
        return reservationId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getReservedSeats() {
        return reservedSeats;
    }

    public String getPurpose() {
        return purpose;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setReservedSeats(Integer reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
