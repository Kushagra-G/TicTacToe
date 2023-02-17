package assignment2;
import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter no1");
        int no1 = in.nextInt();
        System.out.println("Enter no2");
        int no2 = in.nextInt();
        System.out.println("Enter no3");
        int no3 = in.nextInt();

        if (no1>no2 && no2>no3 && no3<no1){

            System.out.println("The numbers ae decreasing");

        }

        else if(no3>no2 && no2>no1 && no1<no3){
            System.out.println("The numbers are increasing");
        }

        else{

            System.out.println("The numbers are neither increasing nor decreasing");
        }

    }
}

