package org.example.cabinvoice;

public class PremiumInvoice implements InvoiceService {
    private static double kmPrice = 15;
    private static double minutePrice = 2;
    private static double minimumPrice = 20;

    public static void setKmPrice(double kmPrice) {
        PremiumInvoice.kmPrice = kmPrice;
    }

    public static void setMinutePrice(double minutePrice) {
        PremiumInvoice.minutePrice = minutePrice;
    }

    public static void setMinimumPrice(double minimumPrice) {
        PremiumInvoice.minimumPrice = minimumPrice;
    }

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
