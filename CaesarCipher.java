

public class CaesarCipher {
    
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final int endIndex = 26 - 1;
    
    private String shiftAlphabet (int key){
        StringBuilder shifted = new StringBuilder("");
        shifted = shifted.append(alphabet.substring(key,alphabet.length()));
        shifted = shifted.append(alphabet.substring(0,key));
        return shifted.toString();
    }
    
    private String convertCaseToLower (String message){
        return message.toLowerCase();
    }
    
    private String mapAlphabets(String message, String original, String shifted){
        StringBuilder mapped = new StringBuilder();
        for (int i = 0; i < message.length() ; ++i){
            char ch = message.charAt(i);
            if (!Character.isLetter(ch)){
                mapped = mapped.append(ch);
                continue;
            }
            int ind = original.indexOf(ch);
            char ch2 = shifted.charAt(ind);
            mapped = mapped.append(ch2);
        }
        return mapped.toString();
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
    
    public String encryptOneKey(String message, int key){
        message = convertCaseToLower(message);
        String shiftedAlphabet = shiftAlphabet(key);
        String encryption = mapAlphabets(message, alphabet, shiftedAlphabet);
        return encryption;
    }
    
    public String encryptTwoKey(String message, int key1, int key2){
        message = convertCaseToLower(message);
        String part1 = getEveryNext(message, 0);
        String part2 = getEveryNext(message, 1);
        String encrypted1 = encryptOneKey(part1, key1);
        String encrypted2 = encryptOneKey(part2, key2);
        String encryption = combineStrings(encrypted1, encrypted2);
        return encryption;
    }
    
    
    public String decryptOneKey(String message, int key){
        message = convertCaseToLower(message);
        String shiftedAlphabet = shiftAlphabet(key);
        String decryption = mapAlphabets(message, shiftedAlphabet, alphabet);
        return decryption;
    }
    
    public String decryptTwoKey(String message, int key1, int key2){
        message = convertCaseToLower(message);
        String part1 = getEveryNext(message, 0);
        String part2 = getEveryNext(message, 1);
        String decrypted1 = decryptOneKey(part1, key1);
        String decrypted2 = decryptOneKey(part2, key2);
        String decryption = combineStrings(decrypted1, decrypted2);
        return decryption;
    }
    
    public void testEncryptOneKey (){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        int key = 15;
        System.out.println("Encrypted - " + encryptOneKey(message, key));
    }
    
    public void testEncryptTwoKey (){
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        int key1 = 21;
        int key2 = 8;
        System.out.println("Encrypted - " + encryptTwoKey(message, key1, key2));
    }
    
    public void testDecryptOneKey (){
        String message = "";
        int key = 0;
        System.out.println("Decrypted - " + decryptOneKey(message, key));
    }
    
    public void testDecryptTwoKey (){
        String message = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        int key1 = 14;
        int key2 = 24;
        System.out.println("Decrypted - " + decryptTwoKey(message, key1, key2));
    }
    
    public void testAllOneKey (){
        String message = "Hello this is Sayan. I am an Engineer in essence.";
        int key = 23;
        String encryption = encryptOneKey(message, key);
        String decryption = decryptOneKey(encryption, key);
        System.out.println("Encrypted - " + encryption);
        System.out.println("Decrypted - " + decryption);
    }
    
    public void testAllTwoKey (){
        String message = "Hello this is Sayan. I am an Engineer in essence.";
        int key1 = 20;
        int key2 = 14;
        String encryption = encryptTwoKey(message, key1, key2);
        String decryption = decryptTwoKey(encryption, key1, key2);
        System.out.println("Encrypted - " + encryption);
        System.out.println("Decrypted - " + decryption);
    }
    
    public void testCombine (){
    String s = "Sayan Paul";
    String s1 = getEveryNext(s,0);
    String s2 = getEveryNext(s,1);
    System.out.println("[O] ->" + s +
                            "\n[0] -> " + s1 + 
                            "\n[1] -> " + s2 + 
                            "\n[C] -> " + combineStrings(s1,s2));
    }
}
