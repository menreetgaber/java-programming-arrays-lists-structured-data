import  edu.duke.*;
import java.util.ArrayList;


public class WordFrequencies
{
    private ArrayList <String> myWords;
    private ArrayList <Integer> myFreqs;

    public WordFrequencies() //...constructor...//
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public int findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        
            for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
        return myFreqs.size();
    
    }

    public int findindexOfMax()
    {
        int max = myFreqs.get(0);
        int index = 0;
        for(int i=1; i<myFreqs.size(); i++)
        {
            if(myFreqs.get(i) > max)
            {
                max = myFreqs.get(i);
                index = i;
            }
        }
        return index;
    }

    public void tester()
    {
        findUnique();
        System.out.println("Total Unique Words: " + myWords.size());
        for(int i=0; i<myWords.size(); i++)
        {
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));
        }
        System.out.println("Max Index: " + findindexOfMax() + " Word that occured MOST: " + myWords.get(findindexOfMax()));
    }

    public static void main (String[] args)
    {
        WordFrequencies TESTCASE = new WordFrequencies();
        TESTCASE.tester();
    }
}
