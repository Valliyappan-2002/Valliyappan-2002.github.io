
package Calculator;

import java.util.*;

public class ConvertInfix
{
  String postfix;
  char infix[];
  Stack<Character> stack; 

 public ConvertInfix(String expr)
  {
    Result res;
    postfix = "";
    stack = new Stack<Character>();
    infix = new char[expr.length()];
    infix = expr.toCharArray();
 }

 int performConversion()
 {
  char temp;
  for(char token : infix)
  {
       if(token == '(')
            stack.push(token);
       else if(token == ')')
       {
           temp = stack.pop();
           while(temp != '(')
           {
             postfix += temp;
             temp = stack.pop();
           }
       }
       else  if( isOperator(token) )
       {
           try
           {
           temp = stack.peek();
           while( !stack.empty() &&  (priority(token) <= priority(temp)) )
           {
             postfix += stack.pop();
             temp = stack.peek();
           }
           stack.push(token);
           }
           catch(Exception ex)
            {
                 stack.push(token);
            }
       }
        else
           postfix += token;
     System.out.println(postfix);
  }

 while( !stack.empty() )
    postfix += stack.pop();
  
   Result tobesent = new Result(postfix);
   return (tobesent.result());
  }

  int priority(char token)
  {
    if(token == '*' || token == '/')
         return 2;
    else if(token == '+' || token == '-')
         return 1;
    return -1;
 }

 boolean isOperator(char token)
 {
  if(token == '*' || token == '/' || token == '+' || token == '-')
    return true;
  else
    return false;
 }
}
    

