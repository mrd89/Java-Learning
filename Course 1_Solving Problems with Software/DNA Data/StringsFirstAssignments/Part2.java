
/**
 * Write a description of Part2 here.
 * 
 * @author Mattew Daniel
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String DNA, String startCodon, String stopCodon){
    String gene = "";
    
    // convert to upper case 
    DNA = DNA.toUpperCase();
    startCodon = startCodon.toUpperCase();
    stopCodon = stopCodon.toUpperCase();
    
    int startIndex = DNA.indexOf(startCodon);
    
    if (-1 == startIndex) { return "";}
    
    int endIndex = DNA.indexOf(stopCodon , startIndex +3);
    
    if (-1 == endIndex) { return "";}
    
    if ((endIndex - startIndex)%3 == 0){
    return DNA.substring(startIndex, endIndex +3);
    }
    else { return "";}
    }
    
    
    public void testSimpleGene(){
    
        String DNA1 = "TGATGTTAGGGTAAGTAT"; // should output ATGTTAGGGTAA
        String DNA2 = " TGAATGGAGT"; // should be null
        String DNA3 = "GTATGTGGATAG"; // should be nulL
        String DNA4 = "AAATGATGATGTAATAA"; // should be ATGATGATGTAA
        String DNA5 = "TAATAATAAATGATGTAA"; // should be ATGTGTAA
        
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        
        System.out.println("DNA Sequence is: "+findSimpleGene(DNA1,startCodon,stopCodon));
        System.out.println("DNA Sequence is: "+findSimpleGene(DNA2,startCodon,stopCodon));
        System.out.println("DNA Sequence is: "+findSimpleGene(DNA3,startCodon,stopCodon));
        System.out.println("DNA Sequence is: "+findSimpleGene(DNA4,startCodon,stopCodon));
        System.out.println("DNA Sequence is: "+findSimpleGene(DNA5,startCodon,stopCodon));
        
    
    
    }
    
    
}
