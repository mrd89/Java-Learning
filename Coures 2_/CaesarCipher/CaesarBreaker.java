
import edu.duke.*;


public class CaesarBreaker {

    
    
    public int[] countLetters(String phrase){
        int[] count = new int[26];
        phrase = phrase.toUpperCase();
        String alph ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int indx;
        
        // count all letters in the phrase
        for(int i=0;i<phrase.length();i++){
            if (Character.isLetter(phrase.charAt(i))){
                indx = alph.indexOf(phrase.charAt(i));
                count[indx] ++;
            }
        }
        
        return count;   
    }
    
    public int maxIndex( int[] letterFrequency ){
        int indMax = -1;
        int maxVal = -1;
        
        for(int i=0;i<letterFrequency.length;i++){
            if (letterFrequency[i] > maxVal){
                maxVal = letterFrequency[i];
                indMax = i;
            }
        }
        
        return indMax;
        
    }
    
    public String decrypt(String inMessage){
        
        int[] counts =countLetters(inMessage);
        int key = maxIndex(counts)-4;
        
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(inMessage, 26 - key);
        
        System.out.println("Key is: " +key);
        
        return message;
    }
    
    
     public String splitString(String inMessage,int indx){
        
         StringBuilder message = new StringBuilder();
         
         for(int i=indx;i<inMessage.length();i+=2){
             message.append(inMessage.charAt(i));
            }
         
        
         return message.toString();
        }
    public String decryptTwoKeys(String inMessage){
        
        String message1 = splitString(inMessage,0);
        String message2 = splitString(inMessage,1);
        
        int[] counts =countLetters(message1);
        int key1 = maxIndex(counts)-4;
        
        int[] counts2 = countLetters(message2);
        int key2 = maxIndex(counts2)-4;
        
        System.out.println("Key 1 is: " + key1);
        System.out.println("Key 2 is: " + key2);
        
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encryptTwoKeys(inMessage, 26 - key1, 26-key2);
    
    
        //System.out.println(message.substring(0,6));
        
        
        return message;
    }
    
    public void testDecrypt(){
        
        FileResource fr = new FileResource();
        CaesarCipher cc = new CaesarCipher();
        //String toDecrypt = cc.encryptTwoKeys(fr.toString(),1,7);
        //String toDecrypt = cc.encrypt(fr.toString(),5);
        
        String toDecrypt = fr.asString();
        
        System.out.println("message is" + toDecrypt);
        //String toDecrypt =cc.encryptTwoKeys( "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee simply another test",23,4);
        String message = decryptTwoKeys(toDecrypt);
        
        System.out.println( message.substring(0,100));
    
    
    }
}
