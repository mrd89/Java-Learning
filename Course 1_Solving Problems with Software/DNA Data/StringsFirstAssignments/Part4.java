
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.File;

public class Part4 {
    
    public void pullResources(String domainURL){
    // This function looks at the duke  html page and pulls the 
    // links and outputs them to the terminal
    URLResource page = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    
    int startIndex;
    int endIndex;
    // loop through pages
    for (String s : page.lines()){
        
        //System.out.println(s);
        int pose = s.indexOf(domainURL);
        
        // if the url is in the line
        if (-1 != pose) {
            
            startIndex = s.lastIndexOf("\"",pose); // find actual start
            endIndex = s.indexOf("\"",pose+1); // find end
            
            System.out.println( s.substring(startIndex, endIndex));
            
        
            
        }
        
        
    }
}

public void testResources(){

    String url = "youtube.com";
    
    pullResources(url);
}

    
    }

