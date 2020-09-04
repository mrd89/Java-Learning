
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class CaesarCipher {
    
    
    
    public String encrypt(String input, int key){
        
        
        input = input.toUpperCase();
    
        StringBuilder encrypted = new StringBuilder(input);

       // String alphabet = "abcdefghijklmnpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (key>26){
            key -= 26;
        }
        while(key<0){
            key +=26;
        }
        
                
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        
        int indx = 0;
        for (int i=0;i<input.length();i++){
            
            indx = alphabet.indexOf(input.charAt(i));
            
            if( indx> -1){
                encrypted.setCharAt(i,shiftedAlphabet.charAt(indx));
            }
        
        }
        
   
        return encrypted.toString();

    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
    
        String temp;
        StringBuilder encrypted = new StringBuilder();
    for (int i=0;i<input.length();i++){
    
        if(i%2==0){
            temp = encrypt(String.valueOf(input.charAt(i)),key1);
        } 
        else{
            temp = encrypt(String.valueOf(input.charAt(i)),key2);
        }
        encrypted = encrypted.insert(i,temp);
    }
    
    
    return encrypted.toString();
    
    }
    
    public void testEncryption(){
        
        String toEncrypt = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key = 15;
        
        System.out.println(" Encryption of phrase \"" + toEncrypt + " \"");
        System.out.println("With Key: :" + key);
        System.out.println("is: " + encrypt(toEncrypt,key));
        
        int key1 = 8;
        int key2 = 21;
        System.out.println(" Encryption of phrase \"" + toEncrypt + " \"");
        System.out.println("With Keys: :" + key1 + " and " + key2);
        System.out.println("is: " + encryptTwoKeys(toEncrypt,key1,key2));
        
        toEncrypt = "First Legion";
        key1 = 23;
        key2 = 17;
        System.out.println(" Encryption of phrase \"" + toEncrypt + " \"");
        System.out.println("With Keys: :" + key1 + " and " + key2);
        System.out.println("is: " + encryptTwoKeys(toEncrypt,key1,key2));
        
        
        
        
        
    }

}
