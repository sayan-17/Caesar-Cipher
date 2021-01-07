
public class WordPlay {
    
    private boolean isVowel (char ch){
        switch (ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': return true;
        }
        return false;
    }
    
    public String replaceVowel (String phrase, char ch){
        int len = phrase.length();
        phrase = phrase.toLowerCase();
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < len; i++){
            if (isVowel(phrase.charAt(i)))
                str.append(ch);
            else
                str.append(phrase.charAt(i));  
        }
        return str.toString();
    }
    
    public void testReplceVowel (){
        String text = "Adarsh chutiya hai";
        System.out.println(text + " becomes ");
        text = replaceVowel (text, '*');
        System.out.print(text);
    }
    
    public String emphasize (String phrase, char ch){
        int len = phrase.length();
        phrase = phrase.toLowerCase();
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < len; i++){
            if (ch == phrase.charAt(i))
                if (i % 2 == 0) str.append('+');
                else str.append('*');
            else
                str.append(phrase.charAt(i));
        }
        return str.toString();
    }
    
    public void testEmphasize (){
        String text = "Adarsh chutiya hai";
        System.out.println(text + " becomes ");
        text = emphasize(text, 'a');
        System.out.print(text);
    }
}
