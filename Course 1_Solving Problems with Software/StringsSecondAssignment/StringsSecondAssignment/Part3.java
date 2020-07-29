
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    
    
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
        
        // returns end location of gene
        public int findGene( String dna, int startPose){
        
        dna = dna.toUpperCase();
        
        int startIndex = dna.indexOf("ATG",startPose);
        
        
        if (-1 == startIndex) {return -1;}
        
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
        
        
        if (-1 == currMin) {return -1;}
        
        return currMin +3;
    
     }
    
     public int countGenes(String dna){
        
        
        int index = 0;
        int count = 0;
        
        int currIndex = findGene(dna , index);
        
        
        while (-1 != currIndex){
            count++;
            currIndex = findGene(dna , currIndex);
        }
        
        return count;
        
        
        
        
        }
         
    
    public void testCountGenes(){
    
    // output should be 3, testing each end codon 
    String dna = "ATGTPSTPSTPSTPSTAAATGTPSTPSTPSTPSTAGATGTPSTPSTPSTPSTAA";
    System.out.println("In DNA : \"" + dna + "\":");
    System.out.println("there are " +countGenes(dna) + " genes"); 
   
    // output should be 12, testing each end codon and while loop
    dna = "ATGTPSTPSTPSTPSTAAATGTPSTPSTPSTPSTAGATGTPSTPSTPSTPSTAAATG"+
    "TPSTPSTPSTPSTAAATGTPSTPSTPSTPSTAGATGTPSTPSTPSTPSTAAATGTPSTPSTPS"+
    "TPSTAAATGTPSTPSTPSTPSTAGATGTPSTPSTPSTPSTAAATGTPSTPSTPSTPSTAAATGT"+
    "PSTPSTPSTPSTAGATGTPSTPSTPSTPSTAA";
    System.out.println("In DNA : \"" + dna + "\":");
    System.out.println("there are " +countGenes(dna) + " genes"); 
    
    dna = "AGTAPGTAGPTAPGPTAPGT";
    System.out.println("In DNA : \"" + dna + "\":");
    System.out.println("there are " +countGenes(dna) + " genes"); //should be 0
   
    
    dna = "TTAGGTPATGTPSTPSTPSTPSTAGATGTGTPATGTGA";
    System.out.println("In DNA : \"" + dna + "\":");
    System.out.println("there are " +countGenes(dna) + " genes"); //should be 1
    
    // all tests pass
    
    }
}
