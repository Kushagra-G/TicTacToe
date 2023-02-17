package assignment2;
import java.util.Scanner;
public class q3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("How many hours did you work?");
        double hours = in.nextDouble();

        System.out.println("What is your hourly wage?");
        double wage = in.nextDouble();

        if (hours<40){

            double salary = hours*wage;
            System.out.println("You earned "+ salary +"$ this week");
        }

        else{

            double salary = (hours*wage) + (wage*.5)*(hours-40) ;
            System.out.println("You earned "+ salary +"$ this week");

        }


    }
}
