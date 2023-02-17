package assignment2;
import java.text.DecimalFormat;
import java.util.Scanner;
public class q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the cost of your groceries: $");
        double cost = in.nextDouble();

        double couponPercent;
        if (cost < 10) {
            couponPercent = 0;
        }
        else if (cost >= 10 && cost < 60) {
            couponPercent = 0.08;
        }
        else if (cost >= 60 && cost < 150) {
            couponPercent = 0.10;
        }
        else if (cost >= 150 && cost < 210) {
            couponPercent = 0.12;
        }
        else {
            couponPercent = 0.14;
        }

        double couponValue = cost * couponPercent;
        DecimalFormat df = new DecimalFormat("#.00");
        if (couponPercent == 0) {
            System.out.println("You don't win a coupon.");
        }
        else {
            System.out.println("You win a discount coupon of $" + df.format(couponValue) + " (" + df.format(couponPercent * 100) + "% of your purchase)");
        }
    }
}
