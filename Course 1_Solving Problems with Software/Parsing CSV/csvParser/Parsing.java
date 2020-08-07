
/**
 * Write a description of Parsing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;


public class Parsing {
    
    
    public String getCountryInfo(CSVParser parser, String country){
        
        for (CSVRecord record:parser){
            
            String currCountry = record.get("Country");
            
            if (currCountry.contains(country)){
            
            return(currCountry + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
            
            } 
        }
        return("NOT FOUND");
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
    
            
            for(CSVRecord record:parser){
            
                String currExports = record.get("Exports");
                
                if( currExports.contains(exportItem1) && currExports.contains(exportItem2)){
                    System.out.println(record.get("Country"));
                }
            }
    
    
    }
    
    public int getNumberOfExporters(CSVParser parser, String exportItem){
    
        int count = 0;
        for(CSVRecord record:parser){
            
                String currExports = record.get("Exports");
                
                if( currExports.contains(exportItem)){
                    count++;
                }
            }
    
        return count;
    
    
    
    }
    
    public void tests(){
        ///*
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String country = "Nauru";
        String output = getCountryInfo(parser,country);
        
        System.out.println(output);
       // */
       // passed all tests forcountry info
       
       /*
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String export1 ="gold" ;
        String export2 = "diamonds";
        
        listExportersTwoProducts(parser, export1, export2);
        */
        // passed all tests for exportertwoproducts
        
        /*
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String export ="sugar";
        
        System.out.println("There are " + getNumberOfExporters(parser,export) + " exporters of " + export);
        
        */
    
    
    }

}
