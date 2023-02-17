package assignment3;

import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = input.nextInt();

        int count = 0;
        int number = 2;
        int sum = 0;
        while (count < n) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                sum += number;
                count++;
            }
            number++;
        }

        System.out.println("The sum of the first " + n + " prime numbers is: " + sum);
    }
}