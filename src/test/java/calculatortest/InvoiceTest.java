package calculatortest;

import org.example.cabinvoice.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvoiceTest {
    InvoiceService premiumService = new PremiumInvoice();
    InvoiceService nonPremiumService = new NonPremiumInvoice();
    Customer customer = new Customer(1234, premiumService);
    InvoiceGenerator invoice = new InvoiceGenerator();

    @Test
    public void test1() {
        invoice.setRideDetails(customer, 10, 4);//15*4+20
        invoice.setRideDetails(customer, 1, 0);

        double amount = invoice.getInvoice(customer);
        assertEquals(100, amount);
    }

    @ParameterizedTest
    @CsvSource({
            "2,1,20",//15*1+4=19 soo minimum is 20
            "2,3,49",//2*15+3*2=49
    })
    public void test2(int minutes, int km, double result) {
        double amount = invoice.calculateTotalFare(premiumService, minutes, km);
        assertEquals(result, amount);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0"
    })
    public void test3(int minutes, int km) {

        assertThrows(InvalidInputException.class, () -> {

            invoice.calculateTotalFare(nonPremiumService, minutes, km);
        });
    }
   @Test
    public void test4(){
        assertThrows(NullPointerException.class,()->invoice.calculateTotalFare(null,2,4));
    }
    @ParameterizedTest
    @CsvSource({
            "2,3,32",
            "10,6,70"
    })
    public void test5(int minutes,int km,int result){
        double amount=invoice.calculateTotalFare(nonPremiumService,minutes,km);
        assertEquals(result,amount);

    }
    @Test
    public void test6(){
        assertThrows(InvalidInputException.class,()->invoice.calculateTotalFare(premiumService,2,-1));
    }
    @Test
    public void test7(){
        Customer customer=new Customer(101,premiumService);
        invoice.setRideDetails(customer,5,2); //premium 2*5+2*15 =40;
        invoice.setRideDetails(customer,5,2);
        invoice.setRideDetails(customer,5,2);
        double totalAmount=3*40;
        assertEquals(totalAmount,customer.getAmount());
    }
    @Test
    public void test8(){
        assertThrows(InvalidInputException.class,()->invoice.calculateTotalFare(premiumService,-1,10));

    }
    @Test
    public void test9() {
        assertThrows(InvalidInputException.class, () -> invoice.setRideDetails(null, -1, 10));
    }
}
