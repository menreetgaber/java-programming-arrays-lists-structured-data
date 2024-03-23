import edu.duke.FileResource;
import edu.duke.*;
import static java.lang.Character.*;

public class TestCaesarCipherTwo
{

    public int[] countLetters(String message)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[]counts = new int[26];
        for(int i=0; i<message.length(); i++)
        {
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alphabet.indexOf(ch);
            if(dex != -1)
            {
                counts[dex]+=1;
            }
        }
        return counts;
    }
    
    public int[] countLetters(String message , int start) {
        String SmallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = start; i < message.length(); i+=2) {
            char ch = Character.toLowerCase(message.charAt(i));
            int index = SmallAlphabet.indexOf(ch);
            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }

    public int maxIndex(int[] values){
        int maxIndex = 0;
        for(int i =0; i < values.length ; i++){
            if(values[i]>values[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public String halfOfString (String message, int start)
    {
        String res = "";
        for(int i=start; i<message.length(); i+=2)
        {
            res += message.charAt(i);
        }
        return  res;
    }

    public int getKey(String encrypted , int start) {
        int[] counts = countLetters(encrypted, start);
        int maxIdx = maxIndex(counts);
        int dkey = maxIdx - 4;
        if (maxIdx < 4) {
            dkey = dkey + 26;
        }
        return dkey;
    }

    public String breakCaesarCipher(String input) {
        // Determine which key was used to encrypt the message
        int key1 = getKey(input, 0);
        int key2 = getKey(input, 1);
        // Create a CaesarCipher object with the determined key
        CaesarCipherTwo cipher = new CaesarCipherTwo(key1, key2);

        // Decrypt the message using the determined key
        String decrypted = cipher.decrypt(input);

        return decrypted;
     }

    public void simpleTests()
    {

        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipherTwo CIPHER = new CaesarCipherTwo(17, 3);

        String encrypted = CIPHER.encryptTwoKeys(message);
        String decrypted = CIPHER.decrypt(encrypted); //...decrypting with 26-key...//

        System.out.println("Real Message: " + message);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);

        decrypted = breakCaesarCipher(encrypted); //...decrypting with 26-key...//
        System.out.println("Decrypted Message with BREAK: " + decrypted);



    }

    //////////////////////////////////////////////////////////////////////////////////////
    public static void main (String[] args)
    {
        TestCaesarCipherTwo CIPHER = new TestCaesarCipherTwo();
        CIPHER.simpleTests();
    }
}
