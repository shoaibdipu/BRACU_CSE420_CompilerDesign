import java.io.*; 
import java.*;
import java.util.*; 

public class CSE420Lab04{
    public static void main(String[] args)throws Exception{
        
        Scanner sc = new Scanner(new File("input.txt"));
        
        System.out.println("Methods : ");
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String curlyCharacter = sc.next();
            
            if(line.contains("(") && curlyCharacter.contains("{")){
                String [] firstBracketSplitter = line.split("\\(");
                
                String [] preFirst = firstBracketSplitter[0].split("\\ ");
                int preFirstLength = preFirst.length;
                
                System.out.println(preFirst[preFirstLength-1] + "(" + firstBracketSplitter[1] + ", return type :  " + preFirst[preFirstLength-2]);
            }
            
            
        }
    }
}
