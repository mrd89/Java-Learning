
import java.text.*; 
import java.util.*;

public class Tester {
            
    
    void testParseAll(){
        String fileName = "short-test_log";
        LogAnalyzer logs = new LogAnalyzer();
        logs.readFile(fileName);
        logs.printAll();
    
    
    }
    
    public void testUniqueIP(){
        String fileName = "short-test_log";
        LogAnalyzer logs = new LogAnalyzer();
        logs.readFile(fileName);
        int uniqueIPs = logs.countUniqueIPs();
        System.out.println("There are: " + uniqueIPs + "unique IPs");
        
        
    }
    
    
    public void testGreaterThan(){
     String fileName = "short-test_log";
     LogAnalyzer logs = new LogAnalyzer();
     logs.readFile(fileName);
     logs.printAllHigherThanNum(100);
     
    
    
    
    }
    
    public void testUniqueOnDay(){
    
    String fileName = "short-test_log";
    LogAnalyzer logs = new LogAnalyzer();
    logs.readFile(fileName);
    int uniqueIPs = logs.uniqueIPVisitsOnDay("Sep 05");
    System.out.println("There are: " + uniqueIPs + "unique IPs");
    
    }
}
