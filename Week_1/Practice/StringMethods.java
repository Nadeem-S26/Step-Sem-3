import java.util.Scanner;
public class StringMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your First Name and Last name : ");
        String name = sc.nextLine().trim();
        System.out.println("Enter your favourite progrmming : ");
        String Lang = sc.nextLine().trim();
        System.out.println("Describe about your programming experience ; ");
        String exp = sc.nextLine().trim();

        String[] splitName = name.split(" ");
        String first = splitName[0];
        String last = splitName[1];

        int charCount = exp.replace(" ","").length();
        String LangUpper = Lang.toUpperCase();

        System.out.println("First Name: " + first);
        System.out.println("Last Name: " + last);
        System.out.println("Favorite Language: " + LangUpper);
        System.out.println("Experience Character Count (excluding spaces): " + charCount);
        sc.close();
    }
}
