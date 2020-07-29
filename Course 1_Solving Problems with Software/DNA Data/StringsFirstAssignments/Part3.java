
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public Boolean twoOccurences(String a, String b){
        // convert to caps 
        b = b.toUpperCase();
        a = a.toUpperCase();
        
        int firstOccur = a.indexOf(b);
        // check for first occurance
        if(-1 == firstOccur) {
            return false;
        }else { 
            // check for second occurance
            if (-1 == a.indexOf(b,firstOccur+1)){ return false;}
                else{return true;}
        }   
        
        
    }
    
    
    
    public void testTwoOccurences(){
        
        String a = "banana";
        String b = "a"; // true
        System.out.println("is string " +b+ " in " +a + " twice? ANS: " + twoOccurences(a,b));
        
        a = "my favorite red tomato was assasinated by a blue bird";
        b = "tomato" ; // false
        System.out.println("is string " +b+ " in " +a + " twice? ANS: " + twoOccurences(a,b));
        
        a = "a";
        b = "this should not work aaaaa"; // false
        System.out.println("is string " +b+ " in " +a + " twice? ANS: " + twoOccurences(a,b));
        
        
    }
    
    
    public String lastPart(String a, String b){
        // convert to caps 
        b = b.toUpperCase();
        a = a.toUpperCase();
        
        int startIndex = b.indexOf(a);
        if(-1 == startIndex) { return b;} 
        else{
        int aLen = a.length();
        return b.substring(startIndex + aLen , b.length());
    }
    }
    
    public void testLastPart(){
    
        // test 1, output should be ana
        String a = "an";
        String b = "banana";
        System.out.println("The part of the string after an in banana is " + lastPart(a,b));
        
        // test 2, output should be forest
        a = "zoo";
        b = "forest";
        System.out.println("string after zoo in forest is " + lastPart(a,b));
    
    }
    
    
    

}
