package Week_1.Lab;
import java.util.Scanner;
public class FindLength {
    public static int FindLengthWihtoutLength(String str){
        int count = 0;
        try{
            while(true){
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e){} 
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter a sentence: ");
        String s1 = sc.next();
        int count = FindLengthWihtoutLength(s1);
        System.out.println("Count of " + s1 + " is: " +count );
        sc.close();
    }
}
