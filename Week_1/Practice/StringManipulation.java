public class StringManipulation {

    public static void main(String[] args) {
        String s1 = "Trail";
        String s2 = new String("Trail");
        char [] charArray = {'T','r','a','i','l'};
        String s3 = new String(charArray);

        System.out.println("If s1 == s2 : " + (s1 == s2));
        System.out.println("If s1 == s2 : " + (s1 == s3));

        System.out.println("If s1 == s2 : " + (s1.equals(s2)));
        System.out.println("If s1 == s2 : " + (s1.equals(s3)));


        String quote = "Programming Quote:\n\"Code is poetry\" - Unknown\nPath: C:\\Java\\Projects";
        System.out.println("\n" + quote);      
    }
}
