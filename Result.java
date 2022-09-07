
package Calculator;

import java.util.*;

public class Result
{
   char postfix[];
   Stack<Integer> stack;
   int res;
   Result tobesent;
   public Result(String expr)
   {
      postfix = new char[expr.length()];
      stack = new Stack<Integer>();
      postfix = expr.toCharArray();
  }

  int result()
  {
     int operand1,operand2,result;
     for(char token : postfix)
    {
     if(!isOperator(token))
     {
         stack.push(Integer.parseInt( String.valueOf(token)));
     }
     else
     {
         operand2 = stack.pop();
         operand1 = stack.pop();
         stack.push( calculate(operand1,token,operand2) );
      }
    }
    res =  stack.pop();
    return res;
  }

  int calculate(int op1,char token,int op2)
  {
    switch(token)
    {
      case '+' : return (op1 + op2);
      case '-' : return (op1 - op2);
      case '*' : return (op1 * op2);
      case '/' : return (op1 / op2);
      default : return 0;
    }
 }

 boolean isOperator(char token)
 {
  if(token == '*' || token == '/' || token == '+' || token == '-')
    return true;
  else
    return false;
 }

}
                     
   