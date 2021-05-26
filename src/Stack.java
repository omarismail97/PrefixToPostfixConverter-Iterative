/*
   Creating a stack without Lib function
   Date: 2/28/21
   @author: Omar Ismail

*/ 

public class Stack 
{ 
   /*
      creates a stack of strings
      using arrays  
   */
   
    int size; 
    int top; 
    String[] s;  
  
    //function to check if stack is empty 
    public boolean isEmpty() 
    { 
        return (top < 0); 
    } 
    
    //creating stack s 
    Stack(int n) 
    { 
        top = -1; 
        size = n; 
        s = new String[size]; 
    } 
  
    //function to push element in Stack 
    public boolean push(String x) 
    { 
        if (top >= size) 
        { 
        return false; 
        } 
        else
        { 
            s[++top] = x; 
            return true; 
        } 
    } 
  
    //function to pop element from stack 
    public String pop() 
    { 
        if (top < 0) 
        { 
        return null; 
        } 
        else
        { 
            String x = s[top--]; 
            return x; 
        } 
    } 
} 
         