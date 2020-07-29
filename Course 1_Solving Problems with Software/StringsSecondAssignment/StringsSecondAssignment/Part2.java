
/**
 * Checks how many times string a appears in string b (non overlapping)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    
    
    
    public int howMany(String a , String b){
        
        a = a.toUpperCase();
        b = b.toUpperCase();
    
        int index = b.indexOf(a);
        int count = 0;
        int aLength = a.length();
        
        while (-1 != index){
            count ++;
            
            index = b.indexOf(a,index+aLength);
            
        }
        
    return count;
    
    
    }
    
    public void testHowMany(){
        
        String a = "aa";
        String b = "aaaaaaa";
        System.out.println(a + " Appears " + howMany(a,b) + " times in " +b); // should say 3 since 7
        
        a = "tests";
        b = "tests are a test of knowledge testing us"; // testing partial correctness (should ignore)
        System.out.println(a + " Appears " + howMany(a,b) + " times in " +b); // should say 1 
        
        a = "p";
        b = "pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp"; // testing while loop
        System.out.println(a + " Appears " + howMany(a,b) + " times in " +b); // should say 60 
        
        
        
    }
}
