package assignment3;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter a word: ");
        String word = sc.nextLine();

        int n = word.length();
        System.out.println("Output: ");


        for (int len = 1; len <= n; len++) {


            for (int i = 0; i <= n - len; i++) {

                // print the current substring
                System.out.println(word.substring(i, i + len));
            }
        }
    }
}