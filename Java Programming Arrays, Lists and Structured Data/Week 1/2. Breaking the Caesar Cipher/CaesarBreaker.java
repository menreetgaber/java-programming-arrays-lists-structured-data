//import edu.duke.FileResource;

public class CaesarBreaker
{
    public String decrypt(String encrypted)
    {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex-4;
        if(maxDex < 4)
        {
            dkey = 26-(4-maxDex);
        }
        System.out.println("Key is " + dkey);
        return cc.encrypt(encrypted, 26-dkey);
    }
    
    // Decryption using a single key
    public String decrypt(String encrypted, int key) {
        CaesarCipher cc = new CaesarCipher();
        return cc.encrypt(encrypted, 26 - key);
    }

    // Count occurrences of each letter in a string
    public int[] countLetters(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }

    //to calculate the index of the max number in a given array 
    public int maxIndex(int[] values){
        int maxIndex = 0;
        for(int i =0; i < values.length ; i++){
            if(values[i]>values[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //To separate the odd and even chars
    public String halfOfString(String message, int start) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            result.append(message.charAt(i));
        }
        return result.toString();
    }
    
    // Get key for decryption
    public int getKey(String encrypted) {
        int[] counts = countLetters(encrypted);
        int maxIdx = maxIndex(counts);
        int dkey = maxIdx - 4;
        if (maxIdx < 4) {
            dkey = dkey + 26;
        }
        return dkey;
    }

    // Decrypt message encrypted with two keys
    public String decryptTwoKeys(String encrypted) {
        String oddChars = halfOfString(encrypted, 0);
        String evenChars = halfOfString(encrypted, 1);
        int key1 = getKey(oddChars);
        int key2 = getKey(evenChars);
        
        System.out.println("Keys found: " + key1 + ", " + key2);
        
        CaesarCipher cc = new CaesarCipher();
        return cc.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }

    
    void testCaesarBreaker()
    {
        System.out.println("DECRYPTED: " + decrypt("Yjhi p ithi higxcv lxiw adih du ttttttttttttttttth"));
    }
    void testhalfOfString()
    {
        System.out.println("HALF: " + halfOfString("Qbkm Zgis", 1));
    }
    void testdecryptTwoKeys()
    {
        System.out.println("HALF: " + decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu"));
    }

//////////////////////////////////////////////////////////////////////
    public static void main (String[] args)
    {
        CaesarBreaker TESTCASE = new CaesarBreaker();
        //TESTCASE.testCaesarBreaker();
        //TESTCASE.testhalfOfString();
        TESTCASE.testdecryptTwoKeys();
    }
}
