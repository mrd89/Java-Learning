
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
    
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();

     }
        
     
     
     
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         
         for(LogEntry entry : records){
             
             if (!uniqueIPs.contains(entry.getIpAddress())){
                 
                 uniqueIPs.add(entry.getIpAddress());
                 
             }    
         }
         return uniqueIPs.size();  
        }
   
     
     public void printAllHigherThanNum (int num){
         
         for (LogEntry entry:records){
             
             if(entry.getStatusCode()>num){
                 System.out.println(entry.toString());
                }
                
            }
            
        
         
     }
     
     
     public int uniqueIPVisitsOnDay (String someday){
         // someday of format "MMM DD" e,g, "FEB 01"
            ArrayList<String> uniqueIPs = new ArrayList<String>();
         Date dateobj;
         String tempDate;
         
         for (LogEntry entry:records){
             

             dateobj = entry.getAccessTime();
             tempDate = dateobj.toString();
             
             if ( tempDate.contains(someday) & !uniqueIPs.contains(entry.getIpAddress())){
                 
                 uniqueIPs.add(entry.getIpAddress());
             
                }
            }
         
         
         
         
         return uniqueIPs.size();
        }
     
     
     
     public void readFile(String filename) {
         // complete method
         WebLogParser parser = new WebLogParser();
         FileResource fr = new FileResource(filename);
         LogEntry temp;
         for (String file:fr.lines()){
             
             temp = parser.parseEntry(file);
             records.add(temp);
             
             
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
