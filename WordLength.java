import edu.duke.*;


public class WordLength {
    
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    private int calculateLength(String word){
         int count= 0;
         for (int i = 1; i < word.length() - 1; ++i){
             count++;
            }
         if (Character.isLetter(word.charAt(0)))
            count++;
         if (Character.isLetter(word.charAt(word.length() - 1)))
            count++;
         return count;
    }
    
    public int maxIndex (int[] count){
        int maxIndex = 0;
        for (int i = 0; i < count.length; ++i){
            if (count[i] < count[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
    
    public void countWordLength(FileResource file, int[] counts){
        for (String word : file.words()){
            int len = calculateLength(word);
            if (len < counts.length - 1)
                counts[len]++;
            else
                counts[counts.length - 1]++;
        }
        int i = 0;
        for (int val : counts){
            System.out.println(i++ + " --> " + val);
        }
        int maxIndex = maxIndex(counts);
    }
    
    
    public void test(){
        FileResource file = new FileResource();
        int[] count = new int[31];
        countWordLength(file, count);
    }
}
