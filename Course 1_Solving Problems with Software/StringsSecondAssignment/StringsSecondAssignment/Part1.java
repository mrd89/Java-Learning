
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    
    
    public int findStopCodon(String dna, int startIndex , String stopCodon){
        dna = dna.toUpperCase();
        stopCodon = stopCodon.toUpperCase();
        
        int endIndex =dna.indexOf(stopCodon,startIndex+3);
        
        if (-1 ==endIndex) { return -1;}
        
        while ( 0 !=((endIndex - startIndex)%3)){
            
            // find next location of stop codon
            endIndex =dna.indexOf(stopCodon,endIndex+1);
            
            if (-1 ==endIndex) { return -1;}
            
            
        }
        
        return endIndex;
                
        }
        
        
        public String findGene( String dna){
        
        dna = dna.toUpperCase();
        
        int startIndex = dna.indexOf("ATG");
        
        
        if (-1 == startIndex) {return "";}
        
        int currMin = findStopCodon( dna, startIndex+3, "TAA");
        
        int tempIndex = findStopCodon( dna, startIndex+3, "TAG");
        
        // if TAA is not possible gene, or TAG is less than TAA
        if (-1 == currMin || (currMin > tempIndex && -1!= tempIndex)){
            currMin = tempIndex; // set min as the TAG
        }
        
        tempIndex = findStopCodon( dna, startIndex+3, "TGA");
        
        // if min is not possible gene, or TGA is less than min
        if (-1 == currMin || (currMin > tempIndex && -1!= tempIndex)){
            currMin = tempIndex; // set min as the TGA
        }
        
        
        if (-1 == currMin) {return "";}
        
        return dna.substring(startIndex,currMin+3);
    
     }
    
    public void testStopCodon(){
        
        String dna1 = "atgasdasdasdtaa";
        String dna2 = "atgttaataataawetaa";
        
        System.out.println("test on \"" + dna1+ "\"");
        System.out.println(findStopCodon(dna1,6,"TAA"));
        
        System.out.println("test on \"" + dna2+ "\"");
        System.out.println(findStopCodon(dna2,6,"TAA"));
    
    
    }
    
    
    public void testFindGene(){
    
    String dna = "ATGTPSTPSTPSTPSTAA";
    System.out.println("Testing on dna strand:\""  + dna + "\" Output: ");
    System.out.println(findGene(dna)); // output should be atgtpstpstpstpstaa
    
    dna = "ATGTPSTPSTPSTPSTAG";
    System.out.println("Testing on dna strand:\""  + dna + "\" Output: ");
    System.out.println(findGene(dna)); // output should be atgtpstpstpstpstag
    
    dna = "ATGTPSTPSTPSTPSTAA";
    System.out.println("Testing on dna strand:\""  + dna + "\" Output: ");
    System.out.println(findGene(dna)); // output should be atgtpstpstpstpstga
    
    dna = "AGTAPGTAGPTAPGPTAPGT";
    System.out.println("Testing on dna strand:\""  + dna + "\" Output: ");
    System.out.println(findGene(dna)); // NO gene, not even atg 
    
    dna = "TTAGGTPATGTPSTPSTPSTPSTAGATGTGTPATGTGA";
    System.out.println("Testing on dna strand:\""  + dna + "\" Output: ");
    System.out.println(findGene(dna)); // output should be atgtpstpstpstpstaa
    
    
    
    }
}
