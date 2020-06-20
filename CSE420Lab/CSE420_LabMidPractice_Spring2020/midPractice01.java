/* 
 * 
 Question :
 
 Take input identify types and perform the operation. 
 
 Input:
 4 + 5.7
 7.8 * 6.77
 4 ^ 2
 
 Output:
 int add double = 9.7
 double Multiply double = 52.806
 int Power int = 16
 
 */

import java.util.*;
import java.io.*;

public class midPractice01{
    
    
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
    
    
    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner sc;
        String s = null;
        
        sc = new Scanner(new File("inputMidPractice01.txt"));
        
        while(sc.hasNextLine()){
            s = sc.nextLine();
            String [] splStr = s.split("\\ ");
            //System.out.println(splStr.length);
            
            //for(String k : splStr) System.out.print(k + " ");
            
            String [] type = new String[splStr.length];
            
            if(isAnInt(splStr[0])==true) type[0] = "int";
            else if (isADouble(splStr[0])==true) type[0] = "double";
            
            if(splStr[1].contains("+")) type[1] = "add";
            else if(splStr[1].contains("*")) type[1] = "Multiply";
            else if(splStr[1].contains("^")) type[1] = "Power";
            
            if(isAnInt(splStr[2])==true) type[2] = "int";
            else if (isADouble(splStr[2])==true) type[2] = "double";
            
            if(type[0]=="double" || type[2]=="double"){
                double first = Double.parseDouble(splStr[0]);
                double second = Double.parseDouble(splStr[2]);
                
                double result = 0.0;
                
                if(type[1]=="add") result = first + second;
                else if(type[1]=="Multiply") result = first * second;
                else if(type[1]=="Power") result = Math.pow(first, second);
                
                System.out.println(type[0] + " " + type[1] + " " + type[2] + " = " + result);
            }else if((type[0]=="int" && type[2]=="int")){
                
                int first = Integer.parseInt(splStr[0]);
                int second = Integer.parseInt(splStr[2]);
                
                int result = 0;
                
                if(type[1]=="add") result = first + second;
                else if(type[1]=="Multiply") result = first * second;
                else if(type[1]=="Power") result = (int)Math.pow(first, second);
                
                System.out.println(type[0] + " " + type[1] + " " + type[2] + " = " + result);
            }
            
            
        }
    }
}
