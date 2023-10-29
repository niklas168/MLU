// BEWERTUNG 6/7
// b) columns immer eins zu klein, line der letzten Klammer "{" falsch

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class IdentifyBrackets{

    
    public static void main(String[] args){
        if (args.length != 1) {
            System.out.println("Bitte geben Sie den Dateinamen als Argument an.");
            return;
        }
        String filename= args[0];
        try {
            BufferedReader reader=new BufferedReader(new FileReader(filename));
            String line;
            Stack<Character> stack_c = new Stack<>();
            Stack<Integer> stack_i = new Stack<>();
            int lineNumber=1;
           
            while((line=reader.readLine())!=null){
                for (int i=0; i<line.length(); i++){
                    if (isOpenBracket(line.charAt(i))){
                        stack_c.push(line.charAt(i));
                        stack_i.push(lineNumber);
                        stack_i.push(i);
                                         
                    }

                    else if(isCloseBracket(line.charAt(i))){
                       
                        char open_c=stack_c.top();
                        stack_c.pop();
                        int open_i= stack_i.top();
                        stack_i.pop();
                        int open_ln= stack_i.top();
                        stack_i.pop();
                        
                        if (isMatchingBracket(open_c, line.charAt(i))){                            
                            
                            System.out.println("Matching Brackets: '"+open_c +"' at line" + lineNumber+" column "+open_i + " and '"+line.charAt(i)+"' at line "+open_ln); //zweite column Angabe fehlt

                        }
                        
                        
                    }

                }
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }

    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isCloseBracket(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private static boolean isMatchingBracket(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']'); 
    }
}