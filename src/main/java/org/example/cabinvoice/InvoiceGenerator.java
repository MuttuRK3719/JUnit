package org.example.cabinvoice;

public class InvoiceGenerator {
    public double getInvoice(Customer customer) {
        return customer.getAmount();
    }

    public void setRideDetails(Customer customer, int minutes, int km) {
        customer.setRide(customer.getRide() + 1);
        customer.setTotalMinutes(customer.getTotalMinutes() + minutes);
        customer.setTotalTravel(customer.getTotalTravel() + km);
        double amount = calculateTotalFare(customer.getService(), minutes, km);
        customer.setAmount(amount);
    }

    public double calculateTotalFare(InvoiceService service, int minutes, int km) {
        if (service == null) throw new NullPointerException("Invalid service type");
        if (minutes <= 0) throw new InvalidInputException();
        double amount = minutes * service.getMinutePrice();
        amount += km * service.getKmPrice();
        if (amount < service.getMinimumPrice()) {
            amount = service.getMinimumPrice();
        }
        return amount;
    }
}
