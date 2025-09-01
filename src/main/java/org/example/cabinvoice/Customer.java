package org.example.cabinvoice;

public class Customer {
    private int customerId;
    private int totalMinutes;
    private int totalTravel;
    private  int ride;
    InvoiceService service;
    private  double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getRide() {
        return ride;
    }

    public InvoiceService getService() {
        return service;
    }

    public void setRide(int ride) {
        this.ride = ride;
    }

    public Customer(int customerId, InvoiceService service) {
        this.customerId = customerId;
        this.service = service;
    }

    public Customer(int customerId, int totalMinutes, int totalTravel) {
        this.customerId = customerId;
        this.totalMinutes = totalMinutes;
        this.totalTravel = totalTravel;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public int getTotalTravel() {
        return totalTravel;
    }

    public void setTotalTravel(int totalTravel) {
        this.totalTravel = totalTravel;
    }
}
