import java.util.Scanner;

public class Solution {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    private int[] frequency(String a){
        int[] count = new int[alphabet.length()];
        for (int i : count){
            i = 0;
        }
        for (char ch : a.toCharArray()){
            count[alphabet.indexOf(ch)]++;
        }
        return count;
    }
    
    static boolean isAnagram(String a, String b) {
        // Complete the function
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() != b.length())
            return false;
        
        Solution S = new Solution();
        int[] countA = S.frequency(a);
        int[] countB = S.frequency(b);
        
        if (countA == countB)
            return true;
            
        return false;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
    
  
}

