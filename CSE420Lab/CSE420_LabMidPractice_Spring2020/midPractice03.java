/*
 * 
 Question : 
 
 Input Student ID and,
 I. Verify it it's a correct ID or not
 a. Verify if it has 8 digit of length 
 b. No character
 II. If the ID is valid, then, 
 print on which year that student 
 got admitted in.
 
 Sample Input : 
 3
 16101219
 1a123455
 12123
 
 Sample Output:
 Verified and year 2016
 Invalid
 Invalid
 
 */


import java.util.*;
import java.io.*;

public class midPractice03{
    
    public static boolean isAnInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner sc;       
        sc = new Scanner(new File("inputMidPractice03.txt"));
        
        // Reading Testcase
        int testCase = Integer.parseInt(sc.nextLine());
        // System.out.println(testCase);
        
        for (int i = 0; i < testCase; i++) {
            String s = null;
            s = sc.nextLine();
            
            boolean result = isAnInt(s);
            
            if(result==true && s.length()==8){
                System.out.println("Verified ID And Year 20" + s.substring(0,2));
            }else{
                System.out.println("Invalid ID");
            }
        }
    }
}
