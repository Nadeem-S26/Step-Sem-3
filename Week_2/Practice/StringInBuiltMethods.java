package Week_2.Practice;
public class StringInBuiltMethods{
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";
        System.out.println("The Original length of the String : " + sampleText.length());
        String trimmed = sampleText.trim();
        System.out.println("After removing the leading and trailing spaces,new length : " + trimmed.length() );
        System.out.println("Char At index 5 is : " + sampleText.charAt(5));
        System.out.println("Extracting a Substring : " + sampleText.substring(6,17));
        System.out.println("Finding of index of the word \"Fun\" : " + sampleText.indexOf("Fun", 0));
        System.out.println("Contains \"Java\" : "+ sampleText.contains("Java"));
        System.out.println("After Trim where \"Java\" starts with : " + trimmed.startsWith("Java"));
        System.out.println("Ends with '?' : " + sampleText.endsWith("!"));
        System.out.println("To Convert Upper Case : " + sampleText.toUpperCase());
        System.out.println("To Convert Lower Case : " + sampleText.toLowerCase());
        System.out.println("Vowels Count : " +  countVowels(sampleText));
        System.out.println("Occurrences of 'a': ");
        findAllOccurrences(sampleText, 'a');

    }
    public static int countVowels(String s){
        int count = 0;
        String vowels ="aeiouAEIOU";
        for(int i = 0 ;i < s.length(); i++){
            if (vowels.indexOf(s.charAt(i)) != -1){
                count++;
            }
        }
        return count;
    }
    public static void  findAllOccurrences(String s, char l){
        for (int i = 0; i < s.length();i++){
            if(s.charAt(i) == l){
                System.out.println(i);
            }
        }
    }
}