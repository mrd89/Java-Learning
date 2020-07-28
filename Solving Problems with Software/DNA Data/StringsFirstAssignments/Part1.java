
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    
    public String findSimpleGene(String DNA){
    String gene = "";
    
    int startIndex = DNA.indexOf("ATG");
    
    if (-1 == startIndex) { return "";}
    
    int endIndex = DNA.indexOf("TAA" , startIndex +3);
    
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
    
    System.out.println("DNA Sequence is: "+findSimpleGene(DNA1));
    System.out.println("DNA Sequence is: "+findSimpleGene(DNA2));
    System.out.println("DNA Sequence is: "+findSimpleGene(DNA3));
    System.out.println("DNA Sequence is: "+findSimpleGene(DNA4));
    System.out.println("DNA Sequence is: "+findSimpleGene(DNA5));
    
    
    
}

}
