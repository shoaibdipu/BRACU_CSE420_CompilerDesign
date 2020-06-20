import java.util.*;
import java.io.*;

public class CSE420Lab02 {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner sc;
        String s = null;
        
        sc = new Scanner(new File("input.txt"));
        
        // Reading Testcase
        int testCase = Integer.parseInt(sc.nextLine());
        System.out.println(testCase);
        
        for (int i = 0; i < testCase; i++) {
            
            s = sc.nextLine();
            boolean finalResult = false;
            String type = null;
            
            if (s.contains("@")) {
                type = "email";
            } else if (!(s.contains("@")) && (s.contains("."))) {
                type = "web";
            }
            
            if (type == "web") {
                String[] splWeb = s.split("\\.");
                int countWeb = 0;
                
                for (int j = 0; j < splWeb.length; j++) {
                    char[] chWeb = splWeb[j].toCharArray();
                    boolean chResult = false;
                    
                    for (int k = 0; k < chWeb.length; k++) {
                        if (chWeb[k] >= 'A' && chWeb[k] <= 'Z' || chWeb[k] >= 'a' && chWeb[k] <= 'z' || chWeb[k] >= '0' && chWeb[k] <= '9') {
                            chResult = true;
                        } else {
                            chResult = false;
                        }
                    }
                    
                    if (chResult == true) {
                        countWeb++;
                    }
                }
                
                if (countWeb == splWeb.length) {
                    finalResult = true;
                } else {
                    finalResult = false;
                }
                
            } else if (type == "email") {
                String[] splMail = s.split("\\@");
                String[] splMailAgain = null;
                
                int splMailAgainLength = 0;
                int countMail = 0;
                int countMail2 = 0;
                
                for (int j = 0; j < splMail.length; j++) {
                    
                    if (!(splMail[j].contains("."))) {
                        
                        char[] chMail = splMail[j].toCharArray();
                        boolean chResult = false;
                        
                        for (int k = 0; k < chMail.length; k++) {
                            if (chMail[k] >= 'A' && chMail[k] <= 'Z' || chMail[k] >= 'a' && chMail[k] <= 'z' || chMail[k] >= '0' && chMail[k] <= '9') {
                                chResult = true;
                            } else {
                                chResult = false;
                            }
                        }
                        
                        if (chResult == true) {
                            countMail++;
                        }
                        
                    } else if (splMail[j].contains(".")) {
                        splMailAgain = splMail[j].split("\\.");
                        
                        splMailAgainLength = splMailAgain.length;
                        
                        for (int l = 0; l < splMailAgain.length; l++) {
                            char[] chMailAgain = splMailAgain[l].toCharArray();
                            boolean chResultAgain = false;
                            
                            for (int m = 0; m < chMailAgain.length; m++) {
                                if (chMailAgain[m] >= 'A' && chMailAgain[m] <= 'Z' || chMailAgain[m] >= 'a' && chMailAgain[m] <= 'z' || chMailAgain[m] >= '0' && chMailAgain[m] <= '9') {
                                    chResultAgain = true;
                                } else {
                                    chResultAgain = false;
                                }
                                
                                if (chResultAgain == true) {
                                    countMail2++;
                                }
                            }
                            
                            
                        }
                        
                    }
                    
                    if ((countMail+countMail2) == (splMail.length + splMailAgainLength - 1)) {
                        finalResult = true;
                    } else {
                        finalResult = false;
                    }
                    
                }
                
            }
            
            // Output
            if (finalResult = true) {
                System.out.println(type + ", " + (i + 1));
            } else {
                System.out.println("Invalid" + ", " + (i + 1));
            }
            
        }
    }
    
}