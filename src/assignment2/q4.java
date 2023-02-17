package assignment2;
import java.util.Scanner;
public class q4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the temperature value: ");
        double temp = in.nextDouble();
        System.out.print("Please enter ‘C’ for Celsius or ‘F’ for Fahrenheit:");
        char unit = in.next().charAt(0);


        double celsius = 0;
        if (unit == 'F' || unit == 'f') {
            celsius = (temp - 32) * 5 / 9;
        } else {
            celsius = temp;
        }

        if (celsius < 0) {
            System.out.println("The state of water is: solid");
        }
        else if (celsius >= 100) {
            System.out.println("The state of water is: gaseous ");
        }
        else {
            System.out.println("The state of water is: liquid");
        }



        
    }
}

