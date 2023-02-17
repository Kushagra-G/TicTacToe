import java.util.Scanner;

public class ok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        int n = word.length();
        System.out.println("All substrings in ascending order of length: ");

        // outer loop to control length of substring
        for (int len = 1; len <= n; len++) {

            // inner loop to control starting index of substring
            for (int i = 0; i <= n - len; i++) {

                // print the current substring
                System.out.println(word.substring(i, i + len));
            }
        }
    }
}