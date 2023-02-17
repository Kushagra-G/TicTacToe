package assignmnet4;
import java.util.Scanner;

public class Q4 {

    public static boolean passcheck(String pass, String pass2) {

        boolean cond1 = false;
        boolean cond2 = false;
        boolean cond3 = false;
        boolean cond4 = false;
        boolean cond5 = false;

        if (pass.length() >= 7) {
            cond1 = true;
        }
        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if (Character.isUpperCase(ch)) {
                cond2 = true;
            } else if (Character.isLowerCase(ch)) {
                cond3 = true;
            } else if (Character.isDigit(ch)) {
                cond4 = true;
            }
        }
        if (pass.equals(pass2)) {
            cond5 = true;
        }

        return (cond1 && cond2 && cond3 && cond4 && cond5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean valid = false;
        while (!valid) {
            System.out.println("Enter your new password:");
            String password = sc.nextLine();
            System.out.println("Enter your new password again:");
            String password2 = sc.nextLine();

            if (passcheck(password, password2)) {
                System.out.println("Your password is set. Thank you.");
                valid = true;
            } else {
                System.out.println("Password is invalid, please try again.");
            }
        }
    }
}