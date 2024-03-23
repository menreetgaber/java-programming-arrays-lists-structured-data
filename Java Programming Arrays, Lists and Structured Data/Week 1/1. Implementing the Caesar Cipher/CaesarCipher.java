import edu.duke.*;
import static java.lang.Character.*;


public class CaesarCipher {
    
    //this is the modified version 'KEY SENSITIVE'
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String CapitalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SmallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        //Compute the shifted alphabet
        String shiftedCapitalAlphabet = CapitalAlphabet.substring(key)+
        CapitalAlphabet.substring(0,key);
        String shiftedSmallAlphabet = SmallAlphabet.substring(key)+
        SmallAlphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            if(isUpperCase(currChar)){
                int idx = CapitalAlphabet.indexOf(currChar);
                if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedCapitalAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
                }
            }
            else{
                int idx = SmallAlphabet.indexOf(currChar);
                if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedSmallAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
                }
            }
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1 , int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String CapitalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SmallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        //shifted for key1
        String shiftedCapitalAlphabetKey1 = CapitalAlphabet.substring(key1)+
        CapitalAlphabet.substring(0,key1);
        String shiftedSmallAlphabetKey1 = SmallAlphabet.substring(key1)+
        SmallAlphabet.substring(0,key1);
        
        //shifted for key2
        String shiftedCapitalAlphabetKey2 = CapitalAlphabet.substring(key2)+
        CapitalAlphabet.substring(0,key2);
        String shiftedSmallAlphabetKey2 = SmallAlphabet.substring(key2)+
        SmallAlphabet.substring(0,key2);
        
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            char newChar;
            if(isUpperCase(currChar)){
                int idx = CapitalAlphabet.indexOf(currChar);
                if (idx != -1) {
                    if (i % 2 == 0) {
                            newChar = shiftedCapitalAlphabetKey1.charAt(idx);
                        } 
                        else {
                            newChar = shiftedCapitalAlphabetKey2.charAt(idx);
                        }
                encrypted.setCharAt(i, newChar);
                }
            }
            else if (isLowerCase(currChar)) {
                int idx = SmallAlphabet.indexOf(currChar);
                if (idx != -1) {
                    if (i % 2 == 0) {
                        newChar = shiftedSmallAlphabetKey1.charAt(idx);
                    } 
                    else {
                        newChar = shiftedSmallAlphabetKey2.charAt(idx);
                    }
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testCaesar()
    {
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        //String encrypted = encrypt(message, 23);
        //System.out.println("key is " + 23 + "\n" + encrypted);
        //System.out.println("ENCRYPTED: " + encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
        System.out.println("ENCRYPTED: " + encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }

    //////////////////////////////////////////////////////////////////////////////////////
    public static void main (String[] args)
    {
        CaesarCipher CIPHER = new CaesarCipher();
        CIPHER.testCaesar();
    }
}
