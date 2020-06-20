/*
 Question: 
 
 Write a regular expression engine who only accepts real numbers.
 Real numbers could be positive or negative, fractional (float or double) or integers.
 
 Sample Input:
 5
 5.5
 5.05
 -5
 -5.05
 5.5.5
 -a
 5.-05
 +5
 
 Sample Output:
 accept
 accept
 accept
 accept
 accept
 reject
 reject
 reject
 accept
 
 */

import java.util.*;
import java.io.*;

public class midPractice02{
    
    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner sc;
        String s = null;
        
        
        sc = new Scanner(new File("inputMidPractice02.txt"));
        while(sc.hasNextLine()){
            s = sc.nextLine();
            if(isAnInt(s)) System.out.println("accepted");
            else if(isADouble(s)) System.out.println("accepted");
            else System.out.println("rejected"); 
        }
        sc.close();
    }
    
    
    public static boolean isAnInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isADouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        
    }
}

