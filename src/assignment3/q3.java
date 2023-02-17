package assignment3;


import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double a = 0.1;

        double b = 0.01;

        double c = 0.01;

        double d = 0.00002;

        double prey = 1000;

        double predator = 20;

        System.out.print("Enter the number of years: ");
        int years = input.nextInt();

        for (int i = 0; i < years; i++) {
            double nextPrey = prey * (1 + a - b * predator);
            double nextPredator = predator * (1 - c + d * prey);
            if (i < years) {
                prey = nextPrey;
                predator = nextPredator;
            }
            }
            System.out.printf("Prey population = " + "%.2f\n", prey);
            System.out.printf("Predator population = " + "%.2f\n", predator);

    }
}