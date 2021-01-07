import edu.duke.*;


public class BreakCaesarCipher {
    
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final char statisticalMaxChar = 'e';
    
    private char getMaxOcc(String message){
        message = message.toLowerCase();
        int[] countArr = new int[alphabet.length()];
        int maxIndex = 0;
        for (int val : countArr){
            val = 0;
        }
         for (int i = 0; i < message.length() ; ++i){
            char ch = message.charAt(i);
            if (!Character.isLetter(ch))
                continue;
            int ind = alphabet.indexOf(ch);
            countArr[ind] ++;
            if (countArr[maxIndex] < countArr[ind])
                maxIndex = ind;
        }
        char maxOcc = (char) alphabet.charAt(maxIndex);
        return maxOcc;
    }
    
    private String getEveryNext (String message, int val){
        StringBuilder string = new StringBuilder();
        while (val < message.length()){
            string = string.append(message.charAt(val));
            val += 2;
        }
        return string.toString();
    }
    
    private String combineStrings(String string1, String string2){
        StringBuilder string = new StringBuilder();
        int ind = 0, ind1 = 0, ind2 = 0;
        while ( ind < string1.length() + string2.length() ){
            if (ind % 2 == 0)
                string = string.append(string1.charAt(ind1++));
            else
                string = string.append(string2.charAt(ind2++));
            ++ind;
        }
        return string.toString();
    }
    
    private int getKey(String message){
        int indexOfMaxOcc = alphabet.indexOf(getMaxOcc(message));
        int indexOfStatisticalMax = alphabet.indexOf(statisticalMaxChar);
        int key = 0;
        if (indexOfStatisticalMax > indexOfMaxOcc)
            key = alphabet.length() - (indexOfStatisticalMax - indexOfMaxOcc);
        else    
            key= indexOfMaxOcc - indexOfStatisticalMax;
        System.out.println("Key - " + key);
        return key;
    }
    
    public String breakCipher (String message){
        int key = getKey(message);
        CaesarCipher CC = new CaesarCipher();
        String decrypted = CC.decryptOneKey(message, key);
        return decrypted;
    }
    
    public String breakCipher2Key (String message){
        String part1 = getEveryNext(message, 0);
        String part2 = getEveryNext(message, 1);
        int key1 = getKey(part1);
        int key2 = getKey(part2);
        CaesarCipher CC = new CaesarCipher();
        String decrypted = CC.decryptTwoKey(message, key1, key2);
        return decrypted;
    }
    
    public void test1Key(){
        String message = "ebiil qefp fp pxvxk. f xj xk bkdfkbbo fk bppbkzb.";
        System.out.println("Decrypted : " + breakCipher(message));
    }
    
    public void test2Key(){
        FileResource file = new FileResource();
        String message = file.asString();
        System.out.println("Decrypted : " + breakCipher2Key(message));
    }
    
    public void testGetMaxOcc(){
    String string = "bsfzi nvcg wm mosoh. w og ub shucbysl cb smgybws.";
    System.out.println("Max occurence is " +  getMaxOcc(string));
    }
}
