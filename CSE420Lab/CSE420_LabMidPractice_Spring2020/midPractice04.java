/*
 * 
 Question : 
 
 Write an engine which only accepts valid identifiers and returns its type. 
 
 Sample Input:
 a = 2
 b = -2777
 c = 3.475892059875322849456
 d123 = 5.5598
 e = 'a'
 $f = "a"
 g/h = "abc"
 66Mohakhali = "University"
 
 Sample Output:
 Valid, a is int
 Valid, b is int
 Valid, c is double
 Valid, d123 is float
 Valid, e is char
 Valid, $f is String
 Invalid identifier, g/h
 Invalid identifier, 66Mohakhali
 
 The rules and convention for naming your identifiers : 
 Rule#01 : 
 An identifier can start with any letter, 
 dollar sign $, or underscore character "_".
 Rule#02 : 
 Subsequent characters can be letters, digits, 
 dollar signs or underscore characters
 
 Difference between float & double :
 A double variable can have a precision up to 15 or 16 decimal points 
 and float can have a precision up to 6 or 7 decimal digits. 
 
 */

import java.util.*;
import java.io.*;

public class midPractice04{
    
    public static boolean identifierChecker(String s){
        
        if (!((s.charAt(0) >= 'a' && s.charAt(0) <= 'z') 
                  || (s.charAt(0)>= 'A' && s.charAt(0) <= 'Z') 
                  || s.charAt(0) == '_'
                  || s.charAt(0) == '$')) 
            return false; 
        
        for (int i = 1; i < s.length(); i++){ 
            if (!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') 
                      || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') 
                      || (s.charAt(i) >= '0' && s.charAt(i) <= '9') 
                      || s.charAt(i) == '_'
                      || s.charAt(i) == '$')) 
                return false; 
        } 
        return true; 
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
    
    public static String floatOrDoubleChecker(String s) {
        String [] splStr = s.split("\\.");
        int precisionLength = splStr[splStr.length-1].length();
        if(precisionLength <= 7){
            return "float";
        }else{
            return "double";
        }
    }
    
    public static String typeChecker(String s){
        if(isAnInt(s)){
            return "int";
        }else if(isADouble(s)){
            String floatOrDoubleCheckerResult = floatOrDoubleChecker(s);
            return floatOrDoubleCheckerResult;
        }else if(s.startsWith("'") && s.endsWith("'")){
            return "char";
        }else{
            return "String";
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc;       
        sc = new Scanner(new File("inputMidPractice04.txt"));
        
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String [] splStr = s.split("\\ ");
            int n = splStr.length;
            
            boolean identifierResult = identifierChecker(splStr[0]);
            
            if(identifierResult==false){
                System.out.println("Invalid identifier, " + splStr[0]);
            }else{
                String type = typeChecker(splStr[splStr.length-1]);
                System.out.println("Valid, " + splStr[0] + " is " + type);
            }
        }
        
    }
}