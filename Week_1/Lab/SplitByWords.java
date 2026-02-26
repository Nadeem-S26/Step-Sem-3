package Week_1.Lab;
import java.util.Scanner;
public class SplitByWords {
    public static int FindLength(String str){
        int count = 0;
        try{
            while(true){
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e){} 
        return count;
    }
    public static String[] splitWordsWithoutBuiltIn(String str){
        int len = FindLength(str);
        int spaceCount = 0;
        for(int i = 0;i < len;i++){
            if(str.charAt(i) == ' '){
                spaceCount++;
            }
        }
        int[] spaceIndxs = new int[spaceCount + 2]; 
        spaceIndxs[0] = -1;
        int idx = 1;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndxs[idx++] = i;
            }
        }    
        spaceIndxs[idx] = len;  
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = spaceIndxs[i] + 1; j < spaceIndxs[i + 1]; j++) {
                word += str.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String s1 = sc.nextLine();
        String[] splitByBulitIn = s1.split(" ");
        String[] spiltWithoutBulitIn = splitWordsWithoutBuiltIn(s1);
        boolean compareArrays = compareArrays(splitByBulitIn, spiltWithoutBulitIn);
        System.out.println("Is both the arrays are true or false ? :" + compareArrays);
        sc.close();   
    }    
}
