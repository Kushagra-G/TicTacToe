package assignmnet4;
import java.util.Scanner;
public class Q3 {


    public static int getRomanLetterValue(String romanLetter){
        switch (romanLetter) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "M":
                return 1000;
            default:
                return 0;
        }


        }
        public static int convertRomanToDecimal(String roman){

        int total = 0;
        while (!roman.isEmpty()) {
            if (roman.length() == 1 || getRomanLetterValue(roman.substring(0, 1)) >= getRomanLetterValue(roman.substring(1, 2))) {
                total += getRomanLetterValue(roman.substring(0, 1));
                roman = roman.substring(1);
            } else {
                int difference = getRomanLetterValue(roman.substring(1, 2)) - getRomanLetterValue(roman.substring(0, 1));
                total += difference;
                roman = roman.substring(2);
            }
        }
        return total;
    }




    public static void main(String[] args) {

        String sbRomanNumeral = "LVII";
        int superBowlValue = convertRomanToDecimal(sbRomanNumeral);
        System.out.println("This year is Super Bowl " + sbRomanNumeral + ", which is number " + superBowlValue + ".");

        // Prompt user to input their own Roman numeral string and display its value in base-10
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your own Roman numeral: ");
        String userRomanNumeral = scanner.nextLine();
        int userValue = convertRomanToDecimal(userRomanNumeral);
        System.out.println(userRomanNumeral + " in base-10 is " + userValue);

    }
}
