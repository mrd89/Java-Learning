
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;


public class WordLengths {

    
    
    public int[] countWordLengths(FileResource resource,int[] counts){
        
        int currLen;
        
        
        // loop through all words in input file resource
        for(String word : resource.words()){
            currLen = 0;
            // check all char in word
            for(int i=0;i<word.length();i++){
                if(Character.isLetter(word.charAt(i))){currLen++;}
            }
        
            if(currLen < counts.length){counts[currLen]++;}
        }
    
    
    
        return counts;
    }
    
    
    public void testLength(){

        FileResource fr = new FileResource("lotsOfWords.txt");
        int[] counts = new int[15];
        counts = countWordLengths(fr,counts);
        
        for(int i=0;i<counts.length;i++){
            System.out.println("There are " + counts[i] + " " +i+" letter long words");
        }
        
    }
}
