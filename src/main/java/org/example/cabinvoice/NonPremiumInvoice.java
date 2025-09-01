package org.example.cabinvoice;

public class NonPremiumInvoice implements InvoiceService {
    private static double kmPrice = 10;
    private static double minutePrice = 1;
    private static double minimumPrice = 5;

    @Override
    public double getMinutePrice() {
        return minutePrice;
    }

    @Override
    public double getMinimumPrice() {
        return minimumPrice;
    }

    @Override
    public double getKmPrice() {
        return kmPrice;
    }
}
