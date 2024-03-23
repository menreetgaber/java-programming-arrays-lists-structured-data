
/**
 * Count common words in Shakespeare's works
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;

public class CommonWords
{
    //There are 20 common words in this file, i want to put them in an array:
    public String[] getCommon(){
        FileResource resource = new FileResource("data/common.txt");
        String[] common = new String[20];
        int index = 0;
        for(String s : resource.words()){
            common[index] = s;
            index += 1;
        }
        return common;
    }
    
    //return the location of a given word in an array of words
    public int indexOf(String[] list, String word) {
        for (int k=0; k<list.length; k++) {
            if (list[k].equals(word)) {
                   return k;
               }
           }
        return -1;
    }
    
    
    //Takes the file, array of common words in it , array with the length of the common words 
    //and count the appearance of each word in (common) and puts the number in the array (counts) in the same location of the word
    public void countWords(FileResource resource, String[] common, int[] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if (index != -1) {
                counts[index] += 1;
            }
        }
    }
    
    
    //store the count of the words that have same length 
    public int[] countWordLengths(FileResource resource, int[] counts){
        for(String word : resource.words()){
            int WordLength =0;
            for (int i = 0; i < word.length(); i++) { 
                char ch = word.charAt(i);
                if (Character.isLetter(ch)) {
                    WordLength++;
                }
            }
            // Handle words equal to or larger than the last index of counts array
            if (WordLength >= counts.length) {
                // count them as the largest size represented in the counts array
                counts[counts.length - 1]++;
            } else {
                counts[WordLength]++;
            }
        }
        return counts;
    }

    public void testCountWordLengths() {
        FileResource fr = new FileResource("smallHamlet.txt");
        int[] counts =new int[31];
        counts = countWordLengths(fr, counts);
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println(counts[i] + " words of length " + i);
            }
        }
        }
    
        
    
        
        
    //to calculate the index of the max number in a given array 
    public int indexOfMax(int[] values){
        int maxIndex = 0;
        for(int i =0; i < values.length ; i++){
            if(values[i]>values[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public void testCountWordLengthsAndMax() {
        FileResource fr = new FileResource("smallHamlet.txt");
        int[] counts =new int[31];
        counts = countWordLengths(fr, counts);
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println(counts[i] + " words of length " + i);
            }
        }
        int mostCommonLength = indexOfMax(counts);
        System.out.println("The most common word length is: " + mostCommonLength);
    }
    
        
    void TestcountShakespeare(){
        //String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
            //          "likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] plays = {"small.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for(int k=0; k < plays.length; k++){
            FileResource resource = new FileResource("data/" + plays[k]);
            countWords(resource,common,counts);
            System.out.println("done with " + plays[k]);
        }
        
        for(int k=0; k < common.length; k++){
            System.out.println(common[k] + "\t" + counts[k]);
        }
    }
}
