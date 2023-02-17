package assignment3;
import java.util.Scanner;
public class q1 {
    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);
        System.out.println("Enter the number:");
        int no = in.nextInt();
        int fib1 = 0, fib2 = 1, fibN = 0;
       if (no <= 1) {
           System.out.println(no);
       }

       else {

           for (int i =2; i <=no; i++){

               fibN = fib1 + fib2;
               fib1 = fib2;
               fib2 = fibN;

           }

        }
        System.out.println("Output : " + fibN);
    }
}
