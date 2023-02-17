package assignmnet4;
import java.util.Scanner;

public class Q1 {
    public static boolean allthesame(int x, int y, int z){

        if( x == y && x == z && y==z ){

            return true;
        }
        else{
            return false;
        }
    }

    public static boolean alldiff(int x, int y, int z){

        if( x!=y && x!=z && y!=z){

            return true;
        }
        else{
            return false;
        }
    }

    public static boolean sorted(int x, int y, int z){
        if(x<y && y<z && z>x){
            return true;
        }
        else{
            return false;
        }
    }






    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value for x:");
        int x = sc.nextInt();
        System.out.println("Enter the value for y:");
        int y = sc.nextInt();
        System.out.println("Enter the value for z:");
        int z = sc.nextInt();

        boolean ans = allthesame(x,y,z);
        boolean ans2 = alldiff(x,y,z);
        boolean ans3 = sorted(x,y,z);

        System.out.println("All the same : " + ans);
        System.out.println("All different : " + ans2);
        System.out.println("Sorted : "  + ans3);
    }
}
