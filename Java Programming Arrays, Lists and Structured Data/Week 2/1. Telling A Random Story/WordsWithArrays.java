import java.util.*;

import edu.duke.*;

public class WordsWithArrays {
    
    StorageResource myWords;
    
    public WordsWithArrays() {
        myWords = new StorageResource();
    }
    
    public void readWords(){
        myWords.clear();
        FileResource resource = new FileResource();
        for(String word : resource.words()){
            myWords.add(word.toLowerCase());
        }
    }
    
    public void readWords(String source){
        myWords.clear();
        if (source.startsWith("http")){
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                myWords.add(word.toLowerCase());
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                    myWords.add(word.toLowerCase());
            }
        }
    }
    
    public int getCount(){
        return myWords.size();
    }
    
    public boolean contains(String[] list, int size, String word){
        for(int k=0; k < size; k++){
            if (list[k].equals(word)){
                return true;
            }
        }
        return false;
    }
    
    public int countDifferentArray(){
        int diffCount = 0;
        String[] words = new String[getCount()];
        for(String s : myWords.data()){
             if (! contains(words,diffCount,s)){
                 words[diffCount] = s;
                 diffCount++;
             }
        }
        return diffCount;
    }
    
    public int countDifferentArrayList(){
        ArrayList<String> words = new ArrayList<String>();
        for(String s : myWords.data()){
            if (! words.contains(s)) {
                words.add(s);
            }
        }
        return words.size();
    }
    
    public String getRandomWord(){
        Random rand = new Random();
        int choice = rand.nextInt(myWords.size());
        for(String s : myWords.data()){
            if (choice == 0) {
                return s;
            }
            choice = choice - 1;
        }
        return "*** NEVER HAPPENS ***";
    }

    public String getRandomWord(String[] words) {
        Random rand = new Random();
        int index = rand.nextInt(words.length);
        return words[index];
    }
    
    public void tester(){
        readWords();
        System.out.println("number of words read: "+myWords.size());
        int unique = countDifferentArray();
        System.out.println("array count "+unique);
    }
    

}
