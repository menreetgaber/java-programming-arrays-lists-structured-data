import edu.duke.*;

public class WordPlay
{
    public void digitTest() {
        String test = "ABCabc0123456789';#!";
        for(int k=0; k < test.length(); k++){
            char ch = test.charAt(k);
            if (Character.isDigit(ch)){
               System.out.println(ch+" is a digit"); 
            }
            if (Character.isAlphabetic(ch)){
                System.out.println(ch+" is alphabetic");
            }
            if (ch == '#'){
                System.out.println(ch +" #hashtag");
            }
        }
    }
    
    //convert each character in a sring to uppercase and lowercase
    public void conversionTest(){
        String test = "ABCDEFabcdef123!#";
        for(int k=0; k < test.length(); k++){
            char ch = test.charAt(k);
            char uch = Character.toUpperCase(ch);
            char lch = Character.toLowerCase(ch);
            System.out.println(ch+" "+uch+" "+lch);
        }
    }
    
    //check if vowel char or not
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        boolean isV =false;
        String vowels = "aeiou";
        if(vowels.indexOf(ch)!=-1){
            isV=true;
        }
        return isV;
    } 

    //change the vowels with *
    public String replaceVowels(String phrase , char ch){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<phrase.length();i++){
            char currentChar = phrase.charAt(i);
            if(isVowel(currentChar)){
                result.append(ch);
            }
            else{
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    //replace with  ‘*’ if it is in an odd number location in the string 
    //replace with  ‘+’ if it is in an even number location in the string
    public String emphasize(String phrase , char ch){
        StringBuilder result = new StringBuilder();
        int index = phrase.indexOf(ch);
        phrase = phrase.toLowerCase();
        for(int i =0;i <phrase.length();i++){
            char currentChar = phrase.charAt(i);
            if(currentChar==ch){
                if ((i+1)%2==0){
                    result.append('+');
                }
                else{
                    result.append('*');
                }
            }
            else{
            result.append(currentChar);
            }
        }
        return result.toString();
        }

    public void testisVowel()
    {
        System.out.println("F is vowel..?" + isVowel('a'));
    }
    public void testreplaceVowels()
    {
        System.out.println("Hello World replaced vowels: " + replaceVowels("Hello World",'*'));
    }
    public void testemphasize()
    {
        System.out.println("Mary Bella Abracadabra: " + emphasize("Mary Bella Abracadabra",'a'));
    }

    public static void main (String[] args)
    {
        WordPlay CIPHER = new WordPlay();
        CIPHER.testisVowel();
        CIPHER.testreplaceVowels();
        CIPHER.testemphasize();
    }
}
