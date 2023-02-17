package assignmnet4;
import java.lang.invoke.StringConcatFactory;
import java.util.Scanner;



public class Q2 {




    public static int numCompare(String str1, String str2) {
        int numPos1 = findNumberPosition(str1);
        int numPos2 = findNumberPosition(str2);
        if (numPos1 == -1 || numPos2 == -1) {
            return str1.compareTo(str2);
        } else {
            String substr1 = str1.substring(0, numPos1);
            String substr2 = str2.substring(0, numPos2);
            if (substr1.equals(substr2)) {
                int num1 = Integer.parseInt(str1.substring(numPos1));
                int num2 = Integer.parseInt(str2.substring(numPos2));
                return Integer.compare(num1, num2);
            }
            else {
                return substr1.compareTo(substr2);
            }
        }
    }

    public static int findNumberPosition(String str) {
        int i = str.length() - 1;
        while (i >= 0 && Character.isDigit(str.charAt(i))) {
            i--;
        }
        return i + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string 1: ");
        String strone = sc.nextLine();

        System.out.println("Enter the string 2: ");
        String strtwo = sc.nextLine();

        int ans = numCompare(strone, strtwo);

        System.out.println("Answer :" + ans );
        }
    }

