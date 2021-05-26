/*
   Data Structures Lab 1 
   @author: Omar Ismail
   2/28/21
*/
// Driver code 
public class PrefixToPostfix 
{   
    //function to convert prefix expression
    //to postfix expressions
    public String PretoPost(String prefix) 
    { 
           
      // Create a stack of capacity  
      // equal to length of string 
      int n = prefix.length(); 
      Stack obj = new Stack(n); 
      
     //converting prefix to postfix
     //reads from right to left until length is 0
      for (int i = n-1; i >=0 ; i--) {

         char obj3 = prefix.charAt(i);
         if(isOperator(obj3)){
             String obj1 = obj.pop();
             String obj2 = obj.pop();
             String exp = obj1 + obj2 + String.valueOf(obj3);
             obj.push(exp);
         }
         else{
             obj.push(obj3+"");
         }
     }

      String postfix = obj.pop();
      return postfix;
    
   } 
     //cases used to determine if character is operand or operator
      public boolean isOperator(char c){
        switch (c){
            case '-':
            case '+':
            case '/':
            case '*':
            case '$':
            return true;
        }
        return false;
    }
 

}
