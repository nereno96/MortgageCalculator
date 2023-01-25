import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;
// imports scanner class
public class MortgageCalculation {
    static double housePrice;
    static double loanAmount;
    static double downpayment;
    static double term;
    // (15 years or 30 years)
    static double interestRate;
    static double mortgage;
    static boolean monthly;
    static double pmi = 0;

    public static void main(String[] args) {
        getInfo();
        getMortgage();
    }
    public static void getInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print(" Enter house price: ");
        housePrice = input.nextDouble();
        System.out.print(" Enter loan amount: ");
        loanAmount = input.nextDouble();
        System.out.print(" Enter downpayment: ");
        downpayment = input.nextDouble();
        System.out.print(" Enter loan term (in years): ");
        term = (input.nextDouble() * 12);
        System.out.print(" Enter interest rate: ");
        interestRate = ((input.nextDouble() / 12) / 100);
        System.out.print(" Enter 1 for monthly payments and 2 for biweekly payments: ");
        if (input.nextDouble() == 1)
            monthly = true;
        else
            monthly = false;

    }

    public static void getMortgage() {
        if (downpayment < (housePrice * 0.2)) {
            if (monthly) {
                pmi = loanAmount * 0.01;
            } else {
                pmi = loanAmount * 0.0005;
            }
        }

        mortgage = (loanAmount + pmi) * ((interestRate * (Math.pow(1 + interestRate, term))) / ((Math.pow(1 + interestRate, term)) - 1));
        if (monthly) {
            System.out.println("Your monthly mortgage payment is $" + new BigDecimal(mortgage).setScale(2, RoundingMode.HALF_UP));
        }
        else {
            System.out.println("Your monthly mortgage payment is $" + new BigDecimal(mortgage / 2).setScale(2, RoundingMode.HALF_UP));
        }
    }
}
