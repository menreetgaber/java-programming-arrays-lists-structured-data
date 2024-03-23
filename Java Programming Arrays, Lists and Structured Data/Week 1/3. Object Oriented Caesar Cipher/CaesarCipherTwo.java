import edu.duke.*;
import static java.lang.Character.*;

public class CaesarCipherTwo
{
    private String CapitalAlphabet,SmallAlphabet;
    private String shiftedCapitalAlphabet1, shiftedSmallAlphabet1;
    private String shiftedCapitalAlphabet2, shiftedSmallAlphabet2;

    private int key1,key2;
    
    public CaesarCipherTwo(int key1 , int key2){
        CapitalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SmallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        
        shiftedCapitalAlphabet1 = CapitalAlphabet.substring(key1)+
        CapitalAlphabet.substring(0,key1);
        
        shiftedCapitalAlphabet2 = CapitalAlphabet.substring(key2)+
        CapitalAlphabet.substring(0,key2);
        
        shiftedSmallAlphabet1 = SmallAlphabet.substring(key1)+
        SmallAlphabet.substring(0,key1);
        
        shiftedSmallAlphabet2 = SmallAlphabet.substring(key2)+
        SmallAlphabet.substring(0,key2);
    
        this.key1 = key1;
        this.key2 = key2;        
    }
    

    public String encryptTwoKeys(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            char newChar;
            if(isUpperCase(currChar)){
                int idx = CapitalAlphabet.indexOf(currChar);
                if (idx != -1) {
                    if (i % 2 == 0) {
                            newChar = shiftedCapitalAlphabet1.charAt(idx);
                        } 
                        else {
                            newChar = shiftedCapitalAlphabet2.charAt(idx);
                        }
                encrypted.setCharAt(i, newChar);
                }
            }
            else if (isLowerCase(currChar)) {
                int idx = SmallAlphabet.indexOf(currChar);
                if (idx != -1) {
                    if (i % 2 == 0) {
                        newChar = shiftedCapitalAlphabet1.charAt(idx);
                    } 
                    else {
                        newChar = shiftedCapitalAlphabet2.charAt(idx);
                    }
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    

    public String decrypt(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - key1, 26 - key2);
        return cc.encryptTwoKeys(input);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    public static void main (String[] args)
    {
        CaesarCipherTwo CIPHER = new CaesarCipherTwo(21, 8);
        String ENCRYPT_ME = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = CIPHER.encryptTwoKeys(ENCRYPT_ME); //...encrypting with key...//
        String decrypted = CIPHER.decrypt(encrypted); //...decrypting with 26-key...//
        System.out.println("Real Message: " + ENCRYPT_ME);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
