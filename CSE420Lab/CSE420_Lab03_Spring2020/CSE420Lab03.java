import java.util.*;
import java.util.regex.*;
import java.io.*;

public class CSE420Lab03{
    public static void main(String[]args) throws FileNotFoundException {
        
        Scanner sc;
        String s = null;
        
        sc = new Scanner(new File("input.txt"));
        
        // Reading No Of Regex
        int noOfRe = Integer.parseInt(sc.nextLine());
        //System.out.println(noOfRe);
        String [] arrayRe = new String[noOfRe];
        
        // Filling The Regex Array
        for(int i=0; i<arrayRe.length; i++){
            arrayRe[i] = sc.nextLine();
        }
        
        //for(int i=0; i<arrayRe.length; i++) System.out.println(arrayRe[i]);
        
        // Reading No Of Strings To Check
        int noOfStr = Integer.parseInt(sc.nextLine());
        //System.out.println(noOfStr);
        String [] arrayStr = new String[noOfStr];
        
        // Filling The String Array
        for(int i=0; i<arrayStr.length; i++){
            arrayStr[i] = sc.nextLine();
        }
        
        //for(int i=0; i<arraySt.length; i++) System.out.println(arraySt[i]);
        
        for(int i=0; i<arrayStr.length; i++){
            boolean result = false;
            int count = 0;
            for(int j=0; j<arrayRe.length; j++){
                result = Pattern.matches(arrayRe[j], arrayStr[i]);
                if(result==true){
                    System.out.println("Yes, " + (j+1));
                    count++;
                }
                result = false;
            }
            if(count==0) System.out.println("No, " + "0");
        }
    }   
}
