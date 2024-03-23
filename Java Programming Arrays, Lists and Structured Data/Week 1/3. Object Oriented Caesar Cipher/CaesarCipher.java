import edu.duke.*;
import static java.lang.Character.*;

public class CaesarCipher
{
    private String CapitalAlphabet,SmallAlphabet;
    private String shiftedCapitalAlphabet, shiftedSmallAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        CapitalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SmallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        
        shiftedCapitalAlphabet = CapitalAlphabet.substring(key)+
        CapitalAlphabet.substring(0,key);
        
        shiftedSmallAlphabet = SmallAlphabet.substring(key)+
        SmallAlphabet.substring(0,key);
        mainKey=key;
    }
    
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if(isUpperCase(currChar)){
                int idx = CapitalAlphabet.indexOf(currChar);
                if(idx != -1){
                char newChar = shiftedCapitalAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
                }
            }
            else{
                int idx = SmallAlphabet.indexOf(currChar);
                if(idx != -1){
                char newChar = shiftedSmallAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    

    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }



    //////////////////////////////////////////////////////////////////////////////////////
    public static void main (String[] args)
    {
        CaesarCipher CIPHER = new CaesarCipher(15);
        String ENCRYPT_ME = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = CIPHER.encrypt(ENCRYPT_ME); //...encrypting with key...//
        String decrypted = CIPHER.decrypt(encrypted); //...decrypting with 26-key...//
        System.out.println("Real Message: " + ENCRYPT_ME);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
