/*
   Data Structures Lab 1 
   @author: Omar Ismail
   2/28/21
  
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Lab 1 converts prefix expressions directly to postfix expresions.
It utilizes a stack class that is made from arrays.

*/
public class OIsmail_Lab1
  {
  //Main entry point of the program  
  public static void main(String args[]) 
    { 
    
      String          expressionText;
      BufferedReader  input;
      BufferedWriter  output;
      String          exp;
      String          errorMsg;
      OIsmail_Lab1    project;
        
      project = new OIsmail_Lab1();
     
      //  Check for command line arguments.
      if (args.length != 2) {
         System.out.println("Usage:  java OIsmail_Lab1 [input file pathname]" +
         " [output file pathname]");
            System.exit(1);
        }

      // opening files that will be used for program
      try {
         input = new BufferedReader(new FileReader(args[0]));
         output = new BufferedWriter(new FileWriter(args[1]));
       } catch (Exception ioe) {
          System.err.println(ioe.toString());
          return;
        }
       
       //reads, converts, and writes the postfix expression in outputfile
       //Also contains potential error codes
       PrefixToPostfix convert = new PrefixToPostfix(); 
       exp = project.readExpression(input);
       while (exp != null) {
        errorMsg = " ";
        if (!convert.isOperator(exp.charAt(0))){
          errorMsg = ("No operator at first index");
          project.writeExpression(errorMsg, output);
        }
        else if (exp.length() < 3){
          errorMsg = ("Expression does not meet required minimum length");
          project.writeExpression(errorMsg, output);
        }
        else {
           String postfixExp = convert.PretoPost(exp); 
           project.writeExpression(postfixExp, output); 
        }
        exp = project.readExpression(input); 
       }
   
      //  Clean up and return to the operating system.
        try {
            input.close();
            output.close();
        } catch (Exception x) {
            System.err.println(x.toString());
        }
        return;
      
   }

    //Reads prefix expression from input file. 
    private String readExpression(BufferedReader input) {
    
        String text = "";
        
        try {
            text = input.readLine();
        } catch (IOException iox) {
            System.err.println(iox.toString());
            System.exit(2);
        }
        return text;
    }
    
    //Writes the postfix expression into output file.
    private void writeExpression(String text, BufferedWriter output) {
    
        try {
            output.write(text);  
            output.newLine();
        } catch (IOException iox) {
            System.err.println(iox.toString());
            System.exit(3);
        }
    }
       
   } 
